package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer

Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem, который должен переводить
переданную строку в десятичное число и возвращать его в виде строки.


Требования:
1. В классе Solution должен существовать метод convertToDecimalSystem(String), возвращающий String.
2. Метод convertToDecimalSystem(String) должен иметь модификаторы доступа: public, static.
3. Метод convertToDecimalSystem(String) должен вызывать метод Integer.parseInt(String, int).
4. Метод convertToDecimalSystem(String) должен переводить переданную строку в десятичное число и возвращать его в
виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s)
    {
        //напишите тут ваш код
        if(s != null)
        {
            if(s.length() >= 2)
            {
                switch(s.substring(0,2))
                {
                    case "0x" : return "" + Integer.parseInt(s.substring(2,s.length()),16);
                    case "0b" : return "" + Integer.parseInt(s.substring(2,s.length()),2);
                }
            }
            if (s.charAt(0) == '0') return "" + Integer.parseInt(s,8);
            else return "" + Integer.parseInt(s);
        }
        return null;
    }
}
