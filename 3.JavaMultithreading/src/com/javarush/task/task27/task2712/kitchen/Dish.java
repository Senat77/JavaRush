package com.javarush.task.task27.task2712.kitchen;

public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    Dish(int i)
    {
        duration = i;
    }

    private int duration;

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString()
    {
        StringBuilder dishes = new StringBuilder();
        for (int i = 0; i < Dish.values().length; i++)
        {
            dishes.append(Dish.values()[i]);
            if(i != Dish.values().length - 1)
                dishes.append(", ");
        }
        return dishes.toString();
    }
}
