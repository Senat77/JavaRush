package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = false;
        int sum = 0;
        while(!isExit)
        {
            int i = Integer.parseInt(br.readLine());
            sum += i;
            if(i == -1) isExit = true;
        }
        System.out.println(sum);
    }
}
