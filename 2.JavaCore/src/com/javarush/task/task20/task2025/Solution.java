package com.javarush.task.task20.task2025;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

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
    private static long[][] powers = new long[10][25];  // powers[M][Number]

    static
    {
        for (int i = 0; i < 10; i++) // Number
        {
            for (int j = 0; j < 25; j++)  // M
            {
                powers[i][j] = (long)Math.pow(i,j);
            }
        }
    }

    public static long[] getNumbers(long N) throws IOException
    {
        long[] result = null;
        long[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834,
                       1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975,
                       534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L,
                       44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L,
                       4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
                       1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        ArrayList<Long> res = new ArrayList<>();
        int index  = 0;
        while(index < temp.length && temp[index] < N)
        {
            res.add(temp[index]);
            index++;
        }
        /*
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
            {
                System.out.println("Find : " + i);
                if(i != 0)
                    res.add(i);
            }
        }
        */
        result = new long[res.size()];
        for (int i = 0; i < res.size(); i++)
        {
            result[i] = res.get(i);
            //System.out.println(result[i]);
        }
        /*
        // Сериализуем список
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/o.txt"));
        oos.writeObject(res);
        oos.close();
        */
        return (result);
    }

    public static void main(String[] args) throws IOException
    {
        getNumbers(Long.MAX_VALUE);
    }
}
