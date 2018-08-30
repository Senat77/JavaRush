package com.javarush.task.task27.task2712.ad;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance()
    {
        return ourInstance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public Map<String,Integer> getVideoSet()
    {
        Map<String,Integer> map = new TreeMap<>();
        for(Advertisement a : advertisementStorage.list())
        {
            map.put(a.getName(),a.getHits());
        }
        return map;
    }
}
