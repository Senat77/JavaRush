package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends java.util.Observable
{
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public Order createOrder()
    {
        Order order = null;
        try
        {
            order = new Order(this);
            if(!order.isEmpty())
            {
                ConsoleHelper.writeMessage(order.toString());

                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                setChanged();
                notifyObservers(order);
            }
        }
        catch (NoVideoAvailableException nvae)
        {
            logger.log(Level.INFO,"No video is available for the order " + order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
        return order;
    }

    public void createTestOrder()
    {
        TestOrder order = null;
        try
        {
            order = new TestOrder(this);
            if(!order.isEmpty())
            {
                ConsoleHelper.writeMessage(order.toString());

                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                setChanged();
                notifyObservers(order);
            }
        }
        catch (NoVideoAvailableException nvae)
        {
            logger.log(Level.INFO,"No video is available for the order " + order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }

    @Override
    public String toString()
    {
        // Tablet{number=5}
        return ("Tablet{number=" + number + "}");
    }
}
