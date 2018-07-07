package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10

Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = null;
        try
        {
            // Считываем из файла
            fr = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
            ArrayList<Integer> list = new ArrayList<>();

            while(fr.ready())
            {
                String s = fr.readLine();
                Integer i = Integer.parseInt(s);
                if(i % 2 == 0)
                    list.add(i);
            }

            Integer[] m = new Integer[list.size()];
            list.toArray(m);
            Arrays.sort(m);
            for (Integer i : m)
                System.out.println(i);
        }
        catch(Exception e)
        {

        }

        br.close();
        fr.close();
    }
}
