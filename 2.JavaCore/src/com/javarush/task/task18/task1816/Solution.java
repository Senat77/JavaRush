package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //args = new String[1];
        //args[0] = "d:/a.txt";
        if(args.length != 1) return;

        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        byte[] b = new byte[fis.available()];
        while (fis.available() > 0)
            fis.read(b);
        for (int i = 0; i < b.length; i++)
        {
            if((b[i] >= 'a' && b[i] <= 'z')||(b[i] >= 'A' && b[i] <= 'Z'))
                count++;
        }
        System.out.println(count);
        fis.close();
    }
}
