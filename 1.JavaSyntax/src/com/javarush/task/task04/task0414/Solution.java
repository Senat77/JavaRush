package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt())
        {
            int year = sc.nextInt();
            int days = 365;
            // Столетия
            if(year%100 == 0 && year%400 == 0) days = 366;
            else
            if(year%4 == 0 && year%100 != 0) days = 366;
            System.out.println("количество дней в году: " + days);
        }
    }
}