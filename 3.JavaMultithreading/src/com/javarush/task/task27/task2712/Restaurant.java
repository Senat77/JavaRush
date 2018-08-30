package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args)
    {
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Elly");
        StatisticManager.getInstance().register(cook1);
        StatisticManager.getInstance().register(cook2);
        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tablets = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            Tablet t = new Tablet(i);
            t.addObserver(cook1);
            t.addObserver(cook2);
            tablets.add(t);
        }

        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tablets,ORDER_CREATING_INTERVAL);
        Thread t = new Thread(task);
        t.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        t.interrupt();

        /*
        tablet.addObserver(cook);
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        //directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        */
    }
}
