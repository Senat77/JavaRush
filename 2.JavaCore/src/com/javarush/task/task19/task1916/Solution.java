package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций
    ADDED, REMOVED, SAME.
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(br.readLine());
        FileReader file2 = new FileReader(br.readLine());
        BufferedReader br1 = new BufferedReader(file1);
        BufferedReader br2 = new BufferedReader(file2);
        br.close();

        // Создадим список и загрузим строки из файлов поочередно
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        while(br1.ready() || br2.ready())
        {
            if(br1.ready()) list1.add(br1.readLine());
            if(br2.ready()) list2.add(br2.readLine());
        }
        //br1.close();
        //br2.close();
        file1.close();
        file2.close();

        // Выборка
        while(!list1.isEmpty() && !list2.isEmpty())
        {
            // Если строки совпадают - SAME
            if(list1.get(0).equals(list2.get(0)))
            {
                lines.add(new LineItem(Type.SAME,list1.get(0)));
                list1.remove(0);
                list2.remove(0);
                continue;
            }
            if(list2.size() > 1 && list1.get(0).equals(list2.get(1)))
            {
                // Это добавление строки
                lines.add(new LineItem(Type.ADDED,list2.get(0)));
                list2.remove(0);
                continue;
            }
            // Это удаление
            lines.add(new LineItem(Type.REMOVED,list1.get(0)));
            list1.remove(0);
        }

        // Один из списков может быть не пуст, проверим
        if (!list1.isEmpty())
        {
            // Все оставшееся - с пометкой REMOVED
            while(!list1.isEmpty())
            {
                lines.add(new LineItem(Type.REMOVED,list1.get(0)));
                list1.remove(0);
            }
        }

        if (!list2.isEmpty())
        {
            // Все оставшееся - с пометкой ADDED
            while(!list2.isEmpty())
            {
                lines.add(new LineItem(Type.ADDED,list2.get(0)));
                list2.remove(0);
            }
        }

        for(LineItem li : lines)
        System.out.println(li.type + " " + li.line);
    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
