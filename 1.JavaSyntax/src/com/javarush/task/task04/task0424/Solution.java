package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x[] = new int [3];
        for(int i =0;i<3;i++)
            x[i] = Integer.parseInt(br.readLine());
        int res = 0;
        if(x[0] == x[1]) res = 3;
        if(x[0] == x[2]) res = 2;
        if(x[1] == x[2]) res = 1;
        if(res != 0)
         System.out.println(res);
    }
}
