package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        if ((x > 0) && (x < 1000))
        {
            String res = "";
            if (x % 2 == 0)
                res += "четное ";
            else
                res += "нечетное ";
            switch(Integer.toString(x).length())
            {
                case (1) : {res += "однозначное "; break;}
                case (2) : {res += "двузначное "; break;}
                case (3) : {res += "трехзначное "; break;}
            }
            System.out.println(res + "число");
        }
    }
}
