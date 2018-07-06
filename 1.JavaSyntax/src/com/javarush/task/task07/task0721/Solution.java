package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] m = new int[20];
        int maximum;
        int minimum;

        //напишите тут ваш код
        for (int i = 0; i < 20; i++) {
            m[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(m);
        maximum = m[19];
        minimum = m[0];

        System.out.print(maximum + " " + minimum);
    }
}
