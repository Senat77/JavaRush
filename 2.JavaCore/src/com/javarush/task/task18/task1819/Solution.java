package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();

        byte[] b;
        FileInputStream fis = new FileInputStream(file1);
        b = new byte[fis.available()];
        fis.read(b);


        fis.close();

        FileOutputStream fos = new FileOutputStream(file1);
        fis = new FileInputStream(file2);
        byte[] b2;
        b2 = new byte [fis.available()];
        fis.read(b2);

        fos.write(b2);
        fos.write(b);

        fos.close();
        fis.close();
    }
}
