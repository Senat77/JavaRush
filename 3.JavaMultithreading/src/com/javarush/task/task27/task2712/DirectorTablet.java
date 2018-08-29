package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        Map<Date,Long> res = StatisticManager.getInstance().getVideoProfit();
        long allAmount = 0;
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Date,Long> entry : res.entrySet())
        {
            ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue()/100f);
            allAmount += entry.getValue();
        }
        ConsoleHelper.writeMessage("" + allAmount/100f);
    }

    public void printCookWorkloading()
    {

    }

    public void printActiveVideoSet()
    {

    }

    public void printArchivedVideoSet()
    {

    }
}
