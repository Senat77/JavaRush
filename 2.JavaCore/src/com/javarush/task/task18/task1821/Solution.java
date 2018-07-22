package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //args = new String[1];
        //args[0] = "d:/temp/1.txt";
        if (args.length != 1) return;

        FileInputStream fis = new FileInputStream(args[0]);
        byte[] arr = new byte[fis.available()];
        if(fis.available() > 0)
            fis.read(arr);
        fis.close();

        TreeMap<Character,Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            Character ch = Character.valueOf((char)arr[i]);
            if(map.containsKey(ch))
            {
                map.replace(ch,map.get(ch)+1);
            }
            else
            {
                map.put(ch,1);
            }
        }
        //Collections.sort(map,);
        for (Map.Entry<Character,Integer> e : map.entrySet())
        {
            System.out.print(e.getKey() + " " + e.getValue().toString() + "\n");
        }
    }
}
