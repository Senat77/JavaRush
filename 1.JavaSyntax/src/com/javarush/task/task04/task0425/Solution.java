package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int res = -1;
        if(a > 0)
        {
            if(b > 0) res = 1;
            else res = 4;
        }
        else
        {
            if(b > 0) res = 2;
            else res = 3;
        }
        System.out.println(res);
    }
}
