package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream fos = new FileOutputStream(br.readLine());

        // Считываем данные
        byte[] buf = new byte[fis.available()];
        if(fis.available() > 0)
            fis.read(buf);
        fis.close();

        // Переделка в список
        ArrayList<Double> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(byte b : buf)
        {
            if (b != (byte)' ')
                sb.append((char)b);
            else
            {
                list.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder();
            }
        }
        list.add(Double.parseDouble(sb.toString()));

        for (Double d : list)
        {
            Integer i = (int) Math.round(d);
            fos.write((i.toString() + " ").getBytes());
        }

        fos.close();
    }
}
