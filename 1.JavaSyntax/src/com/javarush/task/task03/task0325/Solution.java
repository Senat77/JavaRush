package com.javarush.task.task03.task0325;

import java.util.Scanner;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            System.out.println("Я буду зарабатывать $" + sc.nextInt() + " в час");
            return;
        }
        System.out.println("Вы ввели не целое число!");
    }
}
