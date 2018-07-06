package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m[] = new int[3];
        for(int i=0;i<3;i++)
            m[i] = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < 3; i++)
            if (m[i] > 0) res++;
        System.out.println(res);
    }
}
