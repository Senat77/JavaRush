package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(br.readLine());
        double r = t % 5;
        if(r >= 4) System.out.println("красный");
        else
            if(r >= 3) System.out.println("жёлтый");
            else
                System.out.println("зелёный");
    }
}