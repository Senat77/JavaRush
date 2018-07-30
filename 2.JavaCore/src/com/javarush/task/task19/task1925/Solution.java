package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше
    6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //args = new String[2];
        //args[0] = "d:/i.txt";
        //args[1] = "d:/o.txt";

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(args[1]);

        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(br.ready())
        {
            list.addAll(Arrays.asList(br.readLine().split(" ")));
        }

        for(String s : list)
        {
            if(s.length() > 6)
            {
                if(sb.length() != 0)
                    sb.append(",");
                sb.append(s);
            }
        }
        fw.write(sb.toString());

        fr.close();
        fw.close();
    }
}
