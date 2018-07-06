package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> l = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            l.add(br.readLine());
        }
        l.remove(2);
        for (int i = l.size()-1; i > -1; i--) {
            System.out.println(l.get(i));
        }
    }
}


