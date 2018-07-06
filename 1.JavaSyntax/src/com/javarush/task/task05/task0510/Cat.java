package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public void initialize(String name)
    {
        this.name = name;
        age = 1;
        weight = 10;
        color = "white or black";
    }

    public void initialize(String name,int weight,int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "undefined";
    }

    public void initialize(String name,int age)
    {
        initialize(name,1,age);
    }

    public void initialize(int weigth,String color)
    {
        age = 1;
        this.weight = weigth;
        this.color = color;
    }

    public void initialize(int weight,String color,String address)
    {
        this.weight = weight;
        this.color = color;
        age = 1;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
