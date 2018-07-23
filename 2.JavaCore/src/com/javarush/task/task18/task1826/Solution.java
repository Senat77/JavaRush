package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //args = new String[3];
        //args[0] = "-d";
        //args[1] = "d:/o.txt";
        //args[2] = "d:/i.txt";

        if(args.length != 3) return;

        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);

        switch(args[0])
        {
            case ("-e"):
            {
                byte[] arr = new byte[fis.available()];
                if(fis.available() > 0)
                {
                    fis.read(arr);
                    for (int i = 0; i < arr.length; i++)
                    {
                        arr[i] = (byte)(arr[i] + 1);
                    }
                    fos.write(arr);
                }
                break;
            }
            case ("-d"):
            {
                byte[] arr = new byte[fis.available()];
                if(fis.available() > 0)
                {
                    fis.read(arr);
                    for (int i = 0; i < arr.length; i++)
                    {
                        arr[i] = (byte)(arr[i] - 1);
                    }
                    fos.write(arr);
                }
                break;
            }
        }

        fis.close();
        fos.close();
    }
}
