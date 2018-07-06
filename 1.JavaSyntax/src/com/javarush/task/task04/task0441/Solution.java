package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.sql.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m [] = new int [3];
        for(int i=0;i<3;i++)
        {
            m[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(m);
        System.out.println(m[1]);
     }
}
