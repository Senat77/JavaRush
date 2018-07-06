package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int min_size = 0,max_size = 0;
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
        {
            String s = br.readLine();
            if(i == 0)
            {
                min_size = max_size = s.length();
            }
            list.add(s);
            sizes.add(s.length());
            if(s.length() < min_size) min_size = s.length();
            if(s.length() > max_size) max_size = s.length();
        }
        for (int i = 0; i < 10; i++)
        {
            if(min_size == sizes.get(i) || max_size == sizes.get(i))
            {
                System.out.println(list.get(i));
                break;
            }
        }
    }
}
