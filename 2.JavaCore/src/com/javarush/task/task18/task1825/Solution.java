package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,String> tm = new TreeMap<>();
        String resFile = "";

        while (true)
        {
            String s = br.readLine();
            if ("end".equals(s)) break;
            if (resFile.equals(""))
            {
                resFile = s.substring(0, s.lastIndexOf(".part"));
                //System.out.println(resFile);
            }
            int number = Integer.parseInt(s.substring(s.lastIndexOf(".part")+5,s.length()));
            //System.out.println(number);
            tm.put(number,s);
        }

        // Набор имен есть, собираем в единый файл
        FileOutputStream fos = new FileOutputStream(resFile);
        for(Map.Entry<Integer,String> e : tm.entrySet())
        {
            FileInputStream fis = new FileInputStream(e.getValue());
            byte[] arr = new byte[fis.available()];
            if(fis.available() > 0)
            {
                fis.read(arr);
                fos.write(arr);
            }
            fis.close();
        }

        fos.close();
        br.close();
    }
}

