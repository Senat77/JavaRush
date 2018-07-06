package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min_length = 0;
        for (int i = 0; i < 5; i++)
        {
            String s = br.readLine();
            strings.add(s);
            if (i == 0)  min_length = s.length();
            if (s.length() < min_length) min_length = s.length();
        }
        for (String s : strings)
        {
            if(s.length() == min_length)
                System.out.println(s);
        }
    }
}
