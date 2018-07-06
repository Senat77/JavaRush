package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for(int row=1;row<=10;row++) {
            for (int col = 1; col <= 10; col++) {
                System.out.print(row * col + " ");
            }
            System.out.println("");
        }
    }
}
