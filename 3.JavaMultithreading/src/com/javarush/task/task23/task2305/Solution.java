package com.javarush.task.task23.task2305;

//import static com.sun.tools.classfile.AccessFlags.Kind.InnerClass;

/*
Inner

Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/
public class Solution
{
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass
    {
    }

    public static Solution[] getTwoSolutions()
    {
        Solution[] sol = new Solution[2];
        for (int i = 0; i < 2 ; i++)
        {
            sol[i] = new Solution();
            //sol[i].innerClasses = new InnerClass[2];
            for (int j = 0; j < 2; j++)
            {
                sol[i].innerClasses[j] = sol[i].new InnerClass();
            }
        }
        return sol;
    }

    public static void main(String[] args)
    {

    }
}
