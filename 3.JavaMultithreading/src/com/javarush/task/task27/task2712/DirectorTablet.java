package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        Map<Date,Long> res = StatisticManager.getInstance().getVideoProfit();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        double allAmount = 0;
        for(Map.Entry<Date,Long> entry : res.entrySet())
        {
            ConsoleHelper.writeMessage(String.format("%s - %.2f",sdf.format(entry.getKey()),entry.getValue()/100d));
            allAmount += entry.getValue();
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f",allAmount/100));
    }

    public void printCookWorkloading()
    {
        Map<Date,Map<String,Integer>> res = StatisticManager.getInstance().getCookWorktime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        for(Map.Entry<Date,Map<String,Integer>> entry : res.entrySet())
        {
            // Дата
            ConsoleHelper.writeMessage(String.format("%s",sdf.format(entry.getKey())));
            // Статистика по поварам
            for(Map.Entry<String,Integer> cookStat : entry.getValue().entrySet())
            {
                ConsoleHelper.writeMessage(cookStat.getKey() + " - " + (int)(Math.ceil(cookStat.getValue()/60f)) + " min");
            }
            //ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet()
    {
        Map<String,Integer> map = StatisticAdvertisementManager.getInstance().getVideoSet();
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            if(entry.getValue() != 0)
                ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printArchivedVideoSet()
    {
        Map<String,Integer> map = StatisticAdvertisementManager.getInstance().getVideoSet();
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 0)
                ConsoleHelper.writeMessage(entry.getKey());
        }
    }
}
