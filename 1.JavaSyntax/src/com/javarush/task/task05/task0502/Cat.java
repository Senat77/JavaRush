package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        if(strength > anotherCat.strength || weight > anotherCat.weight*2)
            return true;
        else return false;
    }

    public static void main(String[] args) {

    }
}
