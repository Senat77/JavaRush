package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook implements Runnable
{
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Cook(String name)
    {
        this.name = name;
    }

    public boolean isBusy()
    {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public void startCookingOrder(Order order)
    {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");

        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(
                        order.getTablet().toString(),
                        name,
                        order.getTotalCookingTime() * 60,
                        order.getDishes()));
        try
        {
            Thread.sleep(10*order.getTotalCookingTime());
        }
        catch (InterruptedException e) {}
        busy = false;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(100);
                Order order = queue.poll();
                if (order != null)
                {
                    startCookingOrder(order);
                }
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    /*
    @Override
    public void update(Observable o, Object arg)
    {
        Order order = (Order)arg;
        ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + order.getTotalCookingTime() + "min");
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(
                        order.getTablet().toString(),
                        name,
                        order.getTotalCookingTime() * 60,
                        order.getDishes()));
        setChanged();
        notifyObservers(arg);
    }
    */
}
