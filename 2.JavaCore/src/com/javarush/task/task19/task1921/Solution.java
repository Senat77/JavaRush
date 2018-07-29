package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        //args = new String [1];
        //args[0] = "d:/i.txt";

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready())
        {
            String s = br.readLine();
            String[] params = s.split(" ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy",Locale.ENGLISH);
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < params.length - 3; i++)
            {
                name.append(params[i]);
                if(i != params.length-4)
                    name.append(" ");
            }
            Date birthday = sdf.parse(params[params.length-3] + " " + params[params.length-2] + " " + params[params.length-1]);
            PEOPLE.add(new Person(name.toString(),birthday));
        }

        /*
        for (int i = 0; i < PEOPLE.size(); i++)
        {
            System.out.println(PEOPLE.get(i).getName() + " " + PEOPLE.get(i).getBirthday());
        }
        */

        fr.close();
    }
}
