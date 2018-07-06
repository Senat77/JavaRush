package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Списки
        ArrayList<Integer> main_list = new ArrayList<Integer>();
        ArrayList<Integer> l3 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        // Читаем основной список
        for (int i = 0; i < 20; i++)
        {
            main_list.add(Integer.parseInt(br.readLine()));
        }
        // Сортировка
        for (int i = 0; i < 20; i++)
        {
            boolean f = true;
            int k = main_list.get(i);
            if(k % 3 == 0)
            {
                l3.add(k);
                f = false;
            }
            if(k % 2 == 0)
            {
                l2.add(k);
                continue;
            }
            if(f)
                l.add(k);
        }

        printList(l3);
        printList(l2);
        printList(l);
    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for(int i : list)
            System.out.println(i);
    }
}
