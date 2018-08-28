package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager
{
    private final AdvertisementStorage storage;// = AdvertisementStorage.getInstance();
    private int timeSeconds;

    // Список перестановок
    ArrayList<ArrayList<Advertisement>> bigList = new ArrayList<>();

    public AdvertisementManager(int timeSeconds)
    {
        storage = AdvertisementStorage.getInstance();
        this.timeSeconds = timeSeconds;
    }

    private long getAmountOfList(List<Advertisement> list)
    {
        long res = 0;
        for(Advertisement a : list)
            res += a.getAmountPerOneDisplaying();
        return res;
    }

    private int getDurationOfList(List<Advertisement> list)
    {
        int res = 0;
        for(Advertisement a : list)
            res += a.getDuration();
        return res;
    }

    private static ArrayList<ArrayList<Advertisement>> permutate(ArrayList<Advertisement> list)
    {
        ArrayList<ArrayList<Advertisement>> result = new ArrayList<ArrayList<Advertisement>>();

        result.add(new ArrayList<Advertisement>());
        for (int i = 0; i < list.size(); i++)
        {
            ArrayList<ArrayList<Advertisement>> current = new ArrayList<ArrayList<Advertisement>>();
            for (ArrayList<Advertisement> l : result)
            {
                for (int j = 0; j < l.size()+1; j++)
                {
                    l.add(j, list.get(i));
                    ArrayList<Advertisement> temp = new ArrayList<Advertisement>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Advertisement>>(current);
        }
        return result;
    }

    public void processVideos()
    {
        if(storage.list().isEmpty())
            throw new NoVideoAvailableException();
        /* Сортируем
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
        */

        // Список подходящих подлительности и кол-ву показов роликов
        List<Advertisement> sourceList = new ArrayList<>();
        for(Advertisement a : storage.list())
        {
            if(a.getDuration() <= timeSeconds && a.getHits() > 0)
                sourceList.add(a);
        }
        System.out.println("sourceList:" + sourceList.size());
        if(sourceList.isEmpty())
            throw new NoVideoAvailableException();

        bigList = permutate((ArrayList<Advertisement>) sourceList);
        System.out.println("BigList:" + bigList.size());
    }
}
