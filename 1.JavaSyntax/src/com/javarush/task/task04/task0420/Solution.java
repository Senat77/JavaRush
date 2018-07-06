package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int size = 3;
        int n[] = new int [size];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<size;i++)
            n[i] = Integer.parseInt(br.readLine());

        // Сортировка
        boolean endsort;
        do
        {
            endsort = true;
            for(int i=0;i<size-1;i++)
            {
                if(n[i] < n[i+1])
                {
                    endsort = false;
                    int p = n[i];
                    n[i] = n [i+1];
                    n[i+1] = p;
                }
            }
        } while(!endsort);

        for(int i : n)
            System.out.print(i + " ");
    }
}
