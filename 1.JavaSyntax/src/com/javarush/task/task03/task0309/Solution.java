package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {

    public static int sum(int l)
    {
        if(l != 1) l += sum(l-1);
        return l;
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for(int i=1;i<=10;i++)
            System.out.println(sum(i));
    }
}
