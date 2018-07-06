package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> l = new ArrayList<>();
        l.add("мама");l.add("мыла");l.add("раму");
        l.add(1,"именно");
        l.add(3,"именно");
        l.add("именно");
        for(String s : l)
            System.out.println(s);
    }
}
