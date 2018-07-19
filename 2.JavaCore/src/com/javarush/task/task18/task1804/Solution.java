package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        Map<Byte,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        while (fis.available() != 0)
        {
            byte b = (byte)fis.read();
            // Ищем байт в map
            if(map.containsKey(b))
            {
                map.put(b,map.get(b)+1);
            }
            else
            {
                map.put(b,1);
            }
        }
        fis.close();
        //System.out.println(map);
        // Находим макс. значения
        for (Map.Entry<Byte,Integer> e : map.entrySet())
            if (e.getValue() < min)
                min = e.getValue();
        for (Map.Entry<Byte,Integer> e : map.entrySet())
            if (e.getValue() == min)
                System.out.print(e.getKey() + " ");
    }
}
