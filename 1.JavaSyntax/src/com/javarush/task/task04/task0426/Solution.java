package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        if (x == 0)
        {
            System.out.println("ноль");
            return;
        }
        String res = "";
        if (x > 0)
            res += "положительное ";
        else
            res += "отрицательное ";
        if (x % 2 == 0)
            res += "четное ";
        else
            res += "нечетное ";
        System.out.println(res + "число");
    }
}
