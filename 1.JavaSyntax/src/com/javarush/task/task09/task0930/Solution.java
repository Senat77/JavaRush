package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию (используй готовый метод isGreaterThan).
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        HashMap<Integer,String> map = new HashMap<>();
        //напишите тут ваш код
        for (int i = 0; i < array.length; i++)  // по всем элементам кроме последнего
        {
            // Определяем тип данных текущего элемента
            // int index = 0;      // Ключ для мапы
            if(isNumber(array[i]))
            {
                // Число
                int val = Integer.parseInt(array[i]);
                for (int j = i + 1; j < array.length; j++)
                {
                    if(isNumber(array[j]))
                    {
                        if (val < Integer.parseInt(array[j]))
                        {
                            String temp = array[j];
                            array[j] = String.valueOf(val);
                            val = Integer.parseInt(temp);
                        }
                    }
                }
                map.put(i, String.valueOf(val));
            }
            else
            {
                // Строка
                String val = array[i];
                for (int j = i + 1; j < array.length; j++)
                {
                    if(!isNumber(array[j]))
                    {
                        if(isGreaterThan(val,array[j]))
                        {
                            String temp = array[j];
                            array[j] = val;
                            val = temp;
                        }
                    }
                }
                map.put(i, val);
            }
        }

        // Переносим мапу в массив
        for(Map.Entry<Integer,String> element : map.entrySet())
        {
            array[element.getKey()] = element.getValue();
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (i == 0 && c == '-' && chars.length == 1)) // не '-'
            {
                return false;
            }
        }
        return true;
    }
}
