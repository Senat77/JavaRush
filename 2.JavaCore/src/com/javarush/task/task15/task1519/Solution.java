package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. меньше либо равно нулю или больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.




Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна прекращать считывать данные с клавиатуры после того, как была введена строка "exit".
3. Если введенная строка содержит точку(".") и может быть корректно преобразована в число типа Double - должен быть
    вызван метод print(Double value).
4. Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0, но
    меньше 128 - должен быть вызван метод print(short value).
5. Если введенная строка может быть корректно преобразована в число типа Integer и полученное число меньше или равно 0
    или больше или равно 128 - должен быть вызван метод print(Integer value).
6. Во всех остальных случаях должен быть вызван метод print(String value).
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //напиште тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String par = br.readLine();

            if ("exit".equals(par)) break;

            Integer i = 0;
            try
            {
                i = Integer.parseInt(par);
            }
            catch (Exception e)
            {
                Double d = 0d;
                try
                {
                    d = Double.parseDouble(par);
                }
                catch (Exception e1)
                {
                    print(par);
                    continue;
                }
                print(d);
                continue;
            }

            if (i > 0 && i < 128)
                print((short)(int)i);
            else
                print(i);
            /*
            if (par.indexOf('.') != -1)
            {
                Double d = 0d;
                try
                {
                    d = Double.parseDouble(par);
                }
                catch (Exception e)
                {
                    Integer i = 0;
                    try
                    {
                        i = Integer.parseInt(par);
                    }
                    catch (Exception e1)
                    {
                        print(par);
                        continue;
                    }

                    if (i > 0 && i < 128)
                        print((short)(int) i);
                    else
                        print(i);
                    continue;
                }
                print(d);
            }*/
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
