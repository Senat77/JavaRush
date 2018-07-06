package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle()
    {
        x = y = radius = 0;
    }

    public Circle(double x,double y)
    {
        this.x = x;
        this.y = y;
        radius = 0;
    }

    public Circle(double x,double y,double radius)
    {
        this(x,y);
        this.radius = radius;
    }

    public Circle(Circle c)
    {
        x = c.x; y = c.y; radius = c.radius;
    }

    public static void main(String[] args) {

    }
}