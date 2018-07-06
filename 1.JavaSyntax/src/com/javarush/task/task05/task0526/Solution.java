package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man m1 = new Man("M1",20,"FFF");
        System.out.println(m1.name + " " + m1.age + " " + m1.address);
        Man m2 = new Man("M2",30,"GGG");
        System.out.println(m2.name + " " + m2.age + " " + m2.address);
        Woman w1 = new Woman("W1",20,"DDD");
        System.out.println(w1.name + " " + w1.age + " " + w1.address);
        Woman w2 = new Woman("W2",44,"WWW");
        System.out.println(w2.name + " " + w2.age + " " + w2.address);
    }

    //напишите тут ваш код
    public static class People
    {
        String name;
        int age;
        String address;

        public People (String name,int age,String address)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }

    public static class Man extends People
    {
         public Man (String name,int age,String address)
        {
            super(name,age,address);
        }
    }

    public static class Woman extends People
    {

        public Woman (String name,int age,String address)
        {
            super(name,age,address);
        }
    }
}
