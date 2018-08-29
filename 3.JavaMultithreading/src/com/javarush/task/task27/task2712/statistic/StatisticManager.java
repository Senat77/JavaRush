package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.time.LocalDate;
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
        private Map<EventType, List<EventDataRow>> storage = new LinkedHashMap<>();

        public StatisticStorage()
        {
            for (EventType eventType : EventType.values())
            {
                storage.put(eventType, new ArrayList<EventDataRow>());
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
