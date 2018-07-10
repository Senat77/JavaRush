package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.LinkedList;
import java.util.List;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try
        {
            float i = 1 / 0;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try
        {
            int[] k = new int[2];
            k[2] = 3;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Integer i = Integer.parseInt(br.readLine());
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            BufferedReader br= null;
            br.readLine();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            List<Integer> list = new LinkedList();
            list.get(5);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //func1(Integer.parseInt(br.readLine()));
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        //exceptions.add(new Excep)
        exceptions.add(new Exception("Fff"));
        exceptions.add(new RuntimeException("gg"));
        exceptions.add(new FormatFlagsConversionMismatchException("ttt",'c'));
        exceptions.add(new ClassNotFoundException("Rrr"));

    }

    public static void func1(int ref) {};
}
