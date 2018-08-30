package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;

public class TestOrder extends Order
{

    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes()
    {
        int dishCount = 3;//(int)(Math.random()*4 + 1);
        for (int i = 0; i < dishCount; i++)
        {
            dishes.add(Dish.values()[(int)(Math.random()*Dish.values().length)]);
        }
    }
}
