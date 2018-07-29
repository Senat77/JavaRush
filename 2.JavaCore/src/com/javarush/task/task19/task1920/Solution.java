package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //args = new String[1];
        //args[0] = "d:/i.txt";

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        TreeMap<String,Double> map = new TreeMap<>();
        while(br.ready())
        {
            String s = br.readLine();
            String name = s.substring(0,s.indexOf(' '));
            Double number = Double.parseDouble(s.substring(s.indexOf(' ') + 1,s.length()));
            if(map.containsKey(name))
            {
                map.put(name,map.get(name) + number);
            }
            else
            {
                map.put(name,number);
            }
        }

        double maxVal = 0;
        for(Map.Entry<String,Double> e : map.entrySet())
        {
            if(e.getValue() > maxVal)
                maxVal = e.getValue();
        }
        for(Map.Entry<String,Double> e : map.entrySet())
        {
            if(e.getValue() == maxVal)
                System.out.println(e.getKey());
        }

        fr.close();
    }
}
