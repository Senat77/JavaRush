package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.


Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //args = new String [1];
        //args[0] = "3";
        if (args.length != 1) return;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
        while (fbr.ready())
        {
            String s = fbr.readLine();
            if(s.startsWith(args[0] + " "))
            {
                System.out.println(s);
                break;
            }
        }
        br.close();
        fbr.close();
    }
}