package com.javarush.task.task22.task2203;

import java.util.ArrayList;
import java.util.Arrays;

/*
Между табуляциями

Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение
    TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if(string == null) throw new TooShortStringException();
        try
        {
            String res = string.substring(string.indexOf("\t")+ 1,string.length());
            return res.substring(0,res.indexOf("\t"));
        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
