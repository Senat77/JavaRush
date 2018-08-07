package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.Arrays;

/*
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
"JavaRush - лучший сервис обучения Java."

Результат:
"- лучший сервис обучения"

Пример:
"Амиго и Диего лучшие друзья!"

Результат:
"и Диего лучшие друзья!"

На некорректные данные бросить исключение TooShortStringException (сделать исключением).


Требования:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение
    TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
    которое следует после 4-го пробела.
*/
public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string)
    {
        if (string == null) throw new TooShortStringException();
        ArrayList<String> str_list = new ArrayList<>(Arrays.asList(string.split(" ")));
        //System.out.println(str_list);
        StringBuilder sb = new StringBuilder();
        try
        {
            for (int i = 1; i < 5; i++)
            {
                sb.append(str_list.get(i));
                if(i != 4) sb.append(" ");
            }
        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }

        //System.out.println("[" + sb.toString() + "]");
        return sb.toString();
    }

    public static class TooShortStringException extends RuntimeException
    {
    }
}
