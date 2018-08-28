package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return br.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> list = new ArrayList<>();
        //writeMessage("Меню : " + Dish.allDishesToString());
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите названия блюд для добавления в заказ (exit - завершение заказа) :");
        while(true)
        {
            String strDish = readString();
            Dish dish = null;
            if("exit".equals(strDish))
                break;
            try
            {
                dish = Dish.valueOf(strDish);
            }
            catch (IllegalArgumentException  | NullPointerException e)
            {
                writeMessage("Ошибка ввода : блюдо отсутствует в списке");
                continue;
            }
            list.add(dish);
        }
        return list;
    }
}
