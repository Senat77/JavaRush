package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            l.add(Integer.parseInt(br.readLine()));
        }

        int max_length = 1;     // Результат
        int cur_length = 1;     // Тек. длина последовательности
        int index = 0;          // Тек. индекс массива , от которого проверяем последовательность
        int cur_index = 1;      // Тек. индекс в проверяемом подмассиве

        while (index != l.size()-1)
        {
            while(l.get(index) == l.get(index + cur_index))
            {
                cur_length++;
                cur_index++;
                if(index + cur_index >= l.size()-1)
                    break;
            }

            if(cur_length > max_length) max_length = cur_length;
            cur_index = 1;
            index++;
            cur_length = 1;
        }

        System.out.println(max_length);
    }
}