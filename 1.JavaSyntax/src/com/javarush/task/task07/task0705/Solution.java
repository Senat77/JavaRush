package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] m = new int[20];
        int[] m1 = new int[10];
        int[] m2 = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++)
        {
            m[i] = Integer.parseInt(br.readLine());
            if(i < 10) m1[i] = m[i];
            else m2[i-10] = m[i];
        }
        for (int k : m2)
            System.out.println(k);
    }
}
