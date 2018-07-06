package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int res = 0;
        String s = Integer.toString(number);
        int i=0;
        if (i < s.length()) {
            do {
                res += s.charAt(i) - '0';
                i++;
            } while (i < s.length());
        }
        return res;
    }
}