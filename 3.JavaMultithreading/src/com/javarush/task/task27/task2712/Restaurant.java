package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Elly");
        cook2.setQueue(orderQueue);
        StatisticManager.getInstance().register(cook1);
        StatisticManager.getInstance().register(cook2);
        Waiter waiter = new Waiter();
        Thread t1 = new Thread(cook1);
        Thread t2 = new Thread(cook2);

        List<Tablet> tablets = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            Tablet t = new Tablet(i);
            t.setOrderQueue(orderQueue);
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
    }
}
