package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant
{
    public static void main(String[] args)
    {
        Cook cook = new Cook("Amigo");
        Tablet tablet = new Tablet(10);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet.addObserver(cook);
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        //directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}