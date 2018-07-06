package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> l = new ArrayList<>();
        for(String s : list)
        {
            if(s.indexOf('р') != -1 && s.indexOf('л') == -1)
                continue;
            if(s.indexOf('л') != -1 && s.indexOf('р') == -1)
                l.add(0,s);
            l.add(0,s);
        }
        return l;
    }
}