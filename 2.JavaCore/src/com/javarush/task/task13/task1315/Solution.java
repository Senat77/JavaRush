package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
1. Создай классы Dog, Cat и Mouse.
2. Реализуй интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.


Требования:
1. Класс Cat должен быть объявлен внутри класса Solution.
2. Класс Dog должен быть объявлен внутри класса Solution.
3. Класс Mouse должен быть объявлен внутри класса Solution.
4. Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
5. Мышь(Mouse) может передвигаться и может быть съедена.
6. Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution {
    public static void main(String[] args) {

    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    public class Dog implements Movable,Eat {
        public void eat() {};
        public void move() {};
    }

    public class Cat implements Movable,Eat,Eatable {
        public void eat() {};
        public void move() {};
        public void eaten() {};
    }

    public class Mouse implements Movable,Eatable {
        public void move() {};
        public void eaten() {};
    }
}