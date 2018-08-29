package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager
{
    private StatisticStorage statisticStorage = new StatisticStorage();

    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance()
    {
        return ourInstance;
    }

    private StatisticManager()
    {
        
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

        private void put(EventDataRow data)
        {
            if (data != null)
                storage.get(data.getType()).add(data);
        }
    }
}
