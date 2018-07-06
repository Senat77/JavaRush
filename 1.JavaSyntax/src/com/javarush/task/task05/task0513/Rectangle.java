package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    int top;
    int left;
    int width;
    int height;

    public void initialize(int top,int left,int width,int height)
    {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top,int left)
    {
        initialize(top,left,0,0);
    }

    public void initialize(int top,int left,int width)
    {
        initialize(top,left,width,width);
    }

    public void initialize(Rectangle r)
    {
        top = r.top;
        left = r.left;
        width = r.width;
        height = r.height;
    }

    public static void main(String[] args) {

    }
}
