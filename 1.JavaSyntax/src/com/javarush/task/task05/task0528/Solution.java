package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM y");
        System.out.println(sdf.format(d));
    }
}
