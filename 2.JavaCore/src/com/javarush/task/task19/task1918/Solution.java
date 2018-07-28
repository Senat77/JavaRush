package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Требования:
1.?Программа должна считывать имя файла с консоли (используй BufferedReader).
2.?BufferedReader для считывания данных с консоли должен быть закрыт.
3.?Программа должна считывать содержимое файла (используй FileReader).
4.?Поток чтения из файла (FileReader) должен быть закрыт.
5.?Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        //args = new String[1];
        //args[0] = "span";

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(br.readLine());
        br.close();

        br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        while(br.ready())
            sb.append(br.readLine());
        fr.close();
        br.close();

        // Парсим
        ArrayList<String> list = new ArrayList<>();
        for(String s : sb.toString().split("[<]"))
            list.add(s);
        // Подрихтуем список
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).contains(">"))
            {
                list.set(i, "<" + list.get(i));
            }
            else
            {
                list.remove(i);
                i--;
            }
        }
        //System.out.println(list);

        // Формируем финальный список
        ArrayList<String> finalList = new ArrayList<>();
        while(!list.isEmpty())
        {
            int nesting = 0;
            // Наименование тега
            String s = list.get(0);
            // Если с параметрами
            if(s.contains(" ") && s.indexOf(' ') < s.indexOf('>'))
                s = s.substring(0,s.indexOf(' '));
            else
                s = s.substring(0, s.indexOf('>'));

            StringBuilder curTag = new StringBuilder();
            curTag.append(list.get(0));
            // Ищем закрывающий тег
            for (int i = 1; i < list.size(); i++)
            {
                if(list.get(i).contains(s))
                {
                    // Еще один открывающий тег, добавляем в строку и увеличиваем вложенность
                    curTag.append(list.get(i));
                    nesting++;
                    continue;
                }
                if(list.get(i).contains("</" + s.substring(1,s.length())))
                {
                    // Закрывающий тег
                    curTag.append(list.get(i));
                    if (nesting == 0)
                    {
                        // Выборка по тек. тегу закончена, удаляем первый и текщий элементы
                        list.remove(i);
                        list.remove(0);
                        finalList.add(curTag.toString());
                        break;
                    }
                    else
                    {
                        nesting--;
                        continue;
                    }
                }
                // Что-то неинтересное нам, просто добавляем к тек. строке
                curTag.append(list.get(i));
            }
        }

        // Распарсили, выводим
        for(String s : finalList)
        {
            if(s.contains(args[0]) && s.indexOf(args[0]) == 1)
                System.out.println(s);

        }
      */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));

        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null)
        {
            sb.append(line);
        }
        reader.close();

        String openTag = "<" + args[0];
        String closeTag = "</" + args[0] + ">";

        // ищем все открывающие тэги и запоминаем их индексы расположения в строке
        List<Integer> openList = new ArrayList<>();
        int startIndex = 0;
        int index;
        while (true)
        {
            index = sb.indexOf(openTag, startIndex);
            if (index == -1) break;
            openList.add(index);
            startIndex = index + 1;
        }

        // ищем все закрывающие тэги и запоминаем их индексы расположения в строке
        List<Integer> closeList = new ArrayList<>();
        startIndex = 0;
        while (true)
        {
            index = sb.indexOf(closeTag, startIndex);
            if (index == -1) break;
            closeList.add(index);
            startIndex = index + 1;
        }

        // берем первый openTag и идем до closeTag, считаю openTag-и по пути (уровень вложенности)
        int closeID, openID, level = 0;
        while (openList.size() != 0)
        {
            for (int i = 0; i < openList.size(); i++)
            {
                if (openList.get(i) < closeList.get(0)) level++;
                else break;
            }
            for (int i = level - 1; i >= 0; i--)
            {
                openID = openList.get(0);
                closeID = closeList.get(i);
                line = sb.substring(openID, closeID);
                System.out.println(line + closeTag);
                openList.remove(0);
                closeList.remove(i);
                level = 0;
                break;
            }

        }
    }
}
