package com.javarush.task.task18.task1828;

/* 
Прайсы 2

CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        /*
        args = new String[5];
        args[0] = "-u";
        args[1] = "198479";
        args[2] = "BUBUBU";
        args[3] = "3.333";
        args[4] = "1024";
        */

        if(args.length != 5 && args.length != 2) return;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        // Считываем файл в список
        ArrayList<String> list = new ArrayList<>();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        while(fr.ready())
        {
            list.add(fr.readLine());
        }
        fr.close();

        switch (args[0])
        {
            case("-u"):
            {
                // Ищем в списке необходимую строку
                for (int i = 0; i < list.size(); i++)
                {
                    if(args[1].equals(list.get(i).substring(0,8).trim()))
                    {
                        // Формируем новую строку
                        StringBuilder sb = new StringBuilder();
                        sb.append(resizeMe(args[1],8));
                        sb.append(resizeMe(args[2],30));
                        sb.append(resizeMe(args[3],8));
                        sb.append(resizeMe(args[4],4));
                        list.set(i,sb.toString());
                    }
                }
                break;
            }
            case("-d"):
            {
                // Ищем в списке необходимую строку
                for (int i = 0; i < list.size(); i++)
                {
                    if(args[1].equals(list.get(i).substring(0,8).trim()))
                    {
                        list.remove(i);
                    }
                }
                break;
            }
        }

        // Записываем новое содержимое файла
        BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++)
        {
            fw.write(list.get(i));
            if(i != list.size()-1)
                fw.newLine();
        }
        fw.close();
    }

    public static String resizeMe (String s,int newSize)
    {
        while (s.length() < newSize)
            s += " ";
        return (s.substring(0,newSize));
    }
}
