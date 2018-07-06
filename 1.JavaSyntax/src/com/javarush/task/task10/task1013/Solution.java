package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        // напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private int age;
        private boolean sex;
        private Human mother;
        private Human father;

        // Конструкторы
        // 1
        public Human()
        {
            firstName = lastName = "";
            age = 0;
            sex = true;
            mother = father = null;
        }

        //2
        public Human (String firstName,String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            age = 0;
            sex = true;
            mother = father = null;
        }

        //3
        public Human (String firstName,String lastName,int age,boolean sex)
        {
            this(firstName,lastName);
            this.age = age;
            this.sex = sex;
        }

        //4
        public Human (String firstName,String lastName,boolean sex)
        {
            this(firstName,lastName);
            this.sex = sex;
        }

        //5
        public Human (Human aHuman)
        {
            firstName = aHuman.firstName;
            lastName = aHuman.lastName;
            age = aHuman.age;
            sex = aHuman.sex;
            mother = aHuman.mother;
            father = aHuman.father;
        }

        //6
        public Human (String firstName,String lastName,int age,boolean sex,Human father,Human mother)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        //7
        public  Human(String firstName,Human father,Human mother)
        {
            this(firstName,father.lastName);
            this.father = father;
            this.mother = mother;
        }

        //8
        public Human(String firstName,String lastName,int age)
        {
            this(firstName,lastName);
            this.age = age;
        }

        //9
        public Human(String lastName)
        {
            this(null,lastName);
        }

        //10
        public Human(boolean sex)
        {
            this("","");
            this.sex = sex;
        }
    }
}
