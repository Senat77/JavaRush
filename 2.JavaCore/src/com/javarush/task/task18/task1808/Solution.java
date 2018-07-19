package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream part1 = new FileOutputStream(br.readLine());
        FileOutputStream part2 = new FileOutputStream(br.readLine());

        if(fis.available() > 0)
        {
            int count = fis.available();
            byte[] arr;
            if (count % 2 == 0)
                arr = new byte[count / 2];
            else
                arr = new byte[count / 2 + 1];
            fis.read(arr);
            part1.write(arr);
            arr = new byte[count / 2];
            fis.read(arr);
            part2.write(arr);
        }

        fis.close();
        part1.close();
        part2.close();
    }
}
