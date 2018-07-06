package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {

    public static int multip(int l)
    {
        if(l != 1)
            l *= multip(l-1);
        return l;
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(multip(10));
    }
}
