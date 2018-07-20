package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream result = new FileOutputStream(br.readLine());
        FileInputStream fis1 = new FileInputStream(br.readLine());
        FileInputStream fis2 = new FileInputStream(br.readLine());

        byte[] b = new byte[fis1.available()];
        if(fis1.available() > 0)
        {
            fis1.read(b);
            result.write(b);
        }

        b = new byte[fis2.available()];
        if(fis2.available() > 0)
        {
            fis2.read(b);
            result.write(b);
        }

        result.close();
        fis1.close();
        fis2.close();
    }
}
