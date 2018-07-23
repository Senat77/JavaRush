package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный
id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка
    с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        /*
        args = new String[4];
        args[0] = "-c";
        args[1] = "Very-very-very long product name, Very-very-very long product name, Very-very-very long product name";
        args[2] = "3.333";
        args[3] = "102";
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = br.readLine();

        if(args.length != 4) return;

        // Находим новый id
        int newId = 0;
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while(fr.ready())
        {
            // Считываем строку и выгрызаем id
            String s = fr.readLine();
            int i = Integer.parseInt(s.substring(0,8).trim());
            if (i > newId)
                newId = i;
        }
        //System.out.println(newId);
        newId++;
        fr.close();

        // Вносим новую запись
        BufferedWriter fw = new BufferedWriter(new FileWriter(fileName,true));
        String nId = String.valueOf(newId);
        String nProd = args[1];
        String nPrice = args[2];
        String nQ = args[3];

        // Идиотский вариант, но должно работать
        while(nId.length() < 8) nId += " ";
        while(nProd.length() < 30) nProd += " ";
        while(nPrice.length() < 8) nPrice += " ";
        while(nQ.length() < 4) nQ += " ";

        fw.newLine();
        fw.write(nId.substring(0,8) + nProd.substring(0,30) + nPrice.substring(0,8) + nQ.substring(0,4));

        fw.close();
    }
}
