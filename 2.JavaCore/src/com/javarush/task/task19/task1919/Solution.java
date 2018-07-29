package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в
    возрастающем порядке по имени.
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

        TreeMap<String,Double> map = new TreeMap<>();
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready())
        {
            String s = br.readLine();
            String name = s.substring(0,s.indexOf(' '));
            // System.out.println(name);
            Double number = Double.parseDouble(s.substring(s.indexOf(' ') + 1,s.length()));
            // Ищем по фамилии
            if(map.containsKey(name))
            {
                map.put(name,map.get(name) + number);
            }
            else
            {
                map.put(name,number);
            }
        }

        for(Map.Entry<String,Double> e : map.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

        fr.close();
    }
}
