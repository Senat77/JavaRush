package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();
        int max_length = 0;
        for (int i = 0; i < 5; i++)
        {
            String s = br.readLine();
            strings.add(s);
            if (s.length() > max_length) max_length = s.length();
        }
        for (String s : strings)
        {
            if(s.length() == max_length)
                System.out.println(s);
        }
    }
}
