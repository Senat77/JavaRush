package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.


Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/
public class Solution
{
    private static long[][] powers = new long[10][10];  // powers[M][Number]

    static
    {
        for (int i = 0; i < 10; i++) // Number
        {
            for (int j = 0; j < 10; j++)  // M
            {
                powers[i][j] = (long)Math.pow(i,j);
            }
        }
    }

    public static long[] getNumbers(long N)
    {
        long[] result = null;
        ArrayList<Long> res = new ArrayList<>();
        for (long i = 0; i < N; i++)
        {
            String s = String.valueOf(i);
            int M = s.length();
            long sum = 0;
            for (int j = 0; j < M; j++)
            {
                sum += powers[Integer.parseInt(s.substring(j,j+1))][M];
            }
            if(sum == i)
                res.add(i);
        }
        result = new long[res.size()];
        for (int i = 0; i < res.size(); i++)
        {
            result[i] = res.get(i);
            System.out.println(result[i]);
        }
        return (result);
        //return result;
    }

    public static void main(String[] args)
    {
        System.out.println(getNumbers(2000000));//(getNumbers(Long.MAX_VALUE));
    }
}
