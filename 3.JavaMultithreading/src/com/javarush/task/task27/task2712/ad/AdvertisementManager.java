package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;

public class AdvertisementManager
{
    private final AdvertisementStorage storage;// = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        storage = AdvertisementStorage.getInstance();
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        if(storage.list().isEmpty())
            throw new NoVideoAvailableException();
        // Сортируем
        Comparator<Advertisement> comparator = new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if(o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying())
                    return (-1);
                if(o1.getAmountPerOneDisplaying() < o2.getAmountPerOneDisplaying())
                    return 1;
                Double d1 = o1.getAmountPerOneDisplaying() / new Double(o1.getDuration());
                Double d2 = o2.getAmountPerOneDisplaying() / new Double(o2.getDuration());
                return d1.compareTo(d2);
            }
        };
        Collections.sort(storage.list(),comparator);
        ConsoleHelper.writeMessage(storage.list().toString());
    }
}
