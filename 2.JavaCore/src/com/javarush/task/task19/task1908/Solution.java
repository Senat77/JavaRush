package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим
    FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с
    конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(br.readLine()));
        br.close();

        StringBuilder sb = new StringBuilder();
        while (fr.ready())
            sb.append(fr.readLine());

        Pattern p = Pattern.compile("(^| )([0-9]){1,15}($| )");
        String s = sb.toString();
        //System.out.println(s);
        Matcher m = p.matcher(s);

        while (m.find())
        {
            String str = s.substring(m.start(),m.end());
            fw.write(str.trim() + " ");
            //System.out.println(s.substring(m.start(),m.end()-1));
        }

        fr.close();
        fw.close();
    }
}
