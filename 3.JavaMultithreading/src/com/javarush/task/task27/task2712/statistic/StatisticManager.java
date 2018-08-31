package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager
{
    private StatisticStorage statisticStorage = new StatisticStorage();
    Set<Cook> cooks = new HashSet<>();

    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance()
    {
        return ourInstance;
    }

    private StatisticManager()
    {
        
    }

    public Set<Cook> getCooks()
    {
        return cooks;
    }

    // Данные по показу рекламы с группировкой по дням
    public Map<Date,Long> getVideoProfit()
    {
        Map<Date,Long> res = new TreeMap<>(Collections.reverseOrder());

        for(EventDataRow data : statisticStorage.get(EventType.SELECTED_VIDEOS))
        {
            VideoSelectedEventDataRow vdata = (VideoSelectedEventDataRow)data;
            Date shortDate = getLocalDate(vdata.getDate());
            if(res.containsKey(shortDate))
            {
                res.put(shortDate,res.get(shortDate) + vdata.getAmount());
            }
            else
            {
                res.put(shortDate,vdata.getAmount());
            }
        }

        return res;
    }

    // Данные по загрузке повара
    public Map<Date,Map<String,Integer>> getCookWorktime()
    {
        Map<Date,Map<String,Integer>> res = new TreeMap<>(Collections.reverseOrder());

        for(EventDataRow data : statisticStorage.get(EventType.COOKED_ORDER))
        {
            CookedOrderEventDataRow cookData = (CookedOrderEventDataRow) data;
            // Дата записи
            Date shortDate = getLocalDate(cookData.getDate());
            // Данные о тек. записи (повар и его время)
            String cookName = cookData.getCookName();
            int curTime = cookData.getTime();
            Map<String,Integer> curDate;

            // Ищем запись о дате в мапе :
            if(!res.containsKey(shortDate))
            {
                // Записей в результате о текущей дате нет, добавляем
                curDate = new TreeMap<>();
                res.put(shortDate,curDate);
            }
            else
            {
                // Получим текущую сабмапу для этой даты :
                curDate = res.get(shortDate);
            }
            // Ищем нужного нам повара и заполняем (или добавляем) данные
            int temp = curDate.containsKey(cookName) ? curDate.get(cookName) + curTime : curTime;
            curDate.put(cookName,temp);
            res.put(shortDate,curDate);
        }

        return res;
    }

    private Date getLocalDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public void register(Cook cook)
    {
        cooks.add(cook);
    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }

    private class StatisticStorage
    {
        private Map<EventType,List<EventDataRow>> storage = new LinkedHashMap<>();

        public StatisticStorage()
        {
            for(EventType eventType : EventType.values())
            {
                storage.put(eventType,new ArrayList<EventDataRow>());
            }
        }

        private List<EventDataRow> get(EventType eventType)
        {
            return storage.get(eventType);
        }

        private void put(EventDataRow data)
        {
            if (data != null)
                storage.get(data.getType()).add(data);
        }
    }
}
