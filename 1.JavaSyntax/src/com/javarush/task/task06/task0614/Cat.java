package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public static ArrayList <Cat> cats = new ArrayList<Cat>();

    String name;

    public Cat()
    {
        this.name = "Cat" + cats.size();
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 10; i++)
        {
            // Cat cat = new Cat();
            cats.add(new Cat());
        }
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for (Cat cat :  Cat.cats)
        {
            System.out.println(cat.name);
        }
    }
}
