package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum;

        //напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        int [] m = new int [N];

        for(int i=0;i<N;i++)
            m[i] = Integer.parseInt(reader.readLine());

        Arrays.sort(m);
        maximum = m[N-1];

        System.out.println(maximum);

        /*
        public class TutorialGC
        {
            public static void main(String [] args)
            {
                Object a = new Integer(100);
                Object b = new Long(100);
                Object c = new String("100");
                a = null;
                a = c;
                c = b;
                b = a;
             }
         }
         */
    }
}
