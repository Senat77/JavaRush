package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double res = 0;
        int count = 0;
        while(true)
        {
            int k = Integer.parseInt(br.readLine());
            if (k == -1) break;
            res += k;
            count++;
        }
        System.out.println(res/count);
    }
}

