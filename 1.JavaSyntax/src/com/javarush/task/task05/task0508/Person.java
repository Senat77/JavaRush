package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
*/

public class Person {
    //напишите тут ваш код
    String name;
    int age;
    char sex;

    void setName(String name) {this.name = name;}
    void setAge(int age) {this.age = age;}
    void setSex(char sex) {this.sex = sex;}
    String getName () {return name;}
    int getAge() {return age;}
    char getSex() {return sex;}

    public static void main(String[] args) {

    }
}
