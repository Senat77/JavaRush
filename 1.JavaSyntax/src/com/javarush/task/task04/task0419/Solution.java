package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n[] = new int[4];
        for(int i=0;i<4;i++)
            n[i] = Integer.parseInt(br.readLine());
        int res = n[0];
        for(int i=1;i<4;i++)
        {
            if (res < n[i]) res = n[i];
        }
        System.out.println(res);
    }
}
