package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно
    преобразовано в число типа double.
5. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть
    корректно преобразовано в число типа double.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String URL = br.readLine();

        // Выделяем подстроку параметров из URL
        String params = URL.substring(URL.indexOf('?') + 1,URL.length());
        // System.out.println(params);

        // Парсим параметры
        HashMap<String,String> p = new HashMap<>();
        while(!params.isEmpty())
        {
            String par = "";
            if(params.indexOf('&') == -1)
            {
                // Это последний параметр
                par = params;
                params = "";
            }
            else
            {
                par = params.substring(0, params.indexOf('&'));
                params = params.substring(params.indexOf('&')+1,params.length());
            }

            // Очередной параметр выделили, разбираем на имя-значение
            if(par.indexOf('=') == -1)
            {
                p.put(par,"");
            }
            else
            {
                p.put(par.substring(0,par.indexOf('=')),par.substring(par.indexOf('=')+1,par.length()));
                par = par.substring(0,par.indexOf('='));
            }
            System.out.print(par + " ");
        }

        System.out.println("");

        // Разбор окончен, ищем obj
        for (Map.Entry<String,String> e : p.entrySet())
        {
            if("obj".equals(e.getKey()))
            {
                try
                {
                    alert(Double.parseDouble(e.getValue()));
                }
                catch (Exception e1)
                {
                    alert(e.getValue());
                }
            }
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
