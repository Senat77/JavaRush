package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //args = new String[2];
        //args[0] = "d:/i.txt";
        //args[1] = "d:/o.txt";

        FileReader fr = new FileReader(args[0]);
        FileWriter fw = new FileWriter(args[1]);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        StringBuilder sb = new StringBuilder();
        while (br.ready())
            sb.append(br.readLine()).append(" ");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(sb.toString().split(" ")));
        //System.out.println(list);
        Pattern p = Pattern.compile("\\d");
        for (int i = 0; i < list.size(); i++)
        {
            Matcher m = p.matcher(list.get(i));
            if(m.find())
            {
                fw.write(list.get(i) + " ");
            }
        }

        fr.close();
        fw.close();
    }
}
