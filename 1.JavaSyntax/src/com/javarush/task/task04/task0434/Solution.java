package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int x = 1, y = 1;
        while (x < 11)
        {
            while (y < 11)
                System.out.print(x * y++ + " ");
            System.out.println("");
            x++;
            y = 1;
        }
    }
}
