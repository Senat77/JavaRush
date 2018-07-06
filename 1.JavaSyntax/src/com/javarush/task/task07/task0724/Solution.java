package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human gf1 = new Human("GF1",true,60);
        Human gf2 = new Human("GF2",true,61);
        Human gm1 = new Human("GM1",false,62);
        Human gm2 = new Human("GM2",false,63);
        Human father = new Human("F",true,35,gf1,gm1);
        Human mother = new Human("M",false,33,gf2,gm2);
        Human d1 = new Human("D1",false,10,father,mother);
        Human d2 = new Human("D2",false,11,father,mother);
        Human d3 = new Human("D3",false,12,father,mother);

        System.out.println(gf1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm1.toString());
        System.out.println(gm2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name,boolean sex,int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            father = null;
            mother = null;
        }

        public Human (String name,boolean sex,int age,Human father,Human mother)
        {
            this (name,sex,age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















