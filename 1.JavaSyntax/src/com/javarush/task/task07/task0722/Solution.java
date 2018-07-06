package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        String s = "";
        ArrayList<String> l = new ArrayList<>();

        while(true)
        {
            s = reader.readLine();
            if("end".equals(s)) break;
            l.add(s);
        }

        for(String str : l)
            System.out.println(str);
    }
}