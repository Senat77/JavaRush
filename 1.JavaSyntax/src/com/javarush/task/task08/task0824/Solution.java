package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать,
трое детей и выводить все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human d1 = new Human("D1",false,10,new ArrayList<Human>());
        Human d2 = new Human("D2",false,12,new ArrayList<Human>());
        Human s1 = new Human("S1",true,5,new ArrayList<Human>());
        Human f = new Human("F",true,40,new ArrayList<>(Arrays.asList(new Human[]{d1, d2, s1})));
        Human m = new Human("M",false,38,new ArrayList<>(Arrays.asList(new Human[]{d1, d2, s1})));
        Human gf1 = new Human("GF1",true,66,new ArrayList<>(Arrays.asList(new Human[]{f})));
        Human gf2 = new Human("GF2",true,68,new ArrayList<>(Arrays.asList(new Human[]{m})));
        Human gm1 = new Human("GM1",false,66,new ArrayList<>(Arrays.asList(new Human[]{f})));
        Human gm2 = new Human("GF2",false,64,new ArrayList<>(Arrays.asList(new Human[]{m})));

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(s1);
        System.out.println(f);
        System.out.println(m);
        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
    }

    public static class Human {
        //напишите тут ваш код
            public String name;
            public boolean sex;
            public  int age;
            ArrayList<Human> children;

            public Human (String name,boolean sex,int age,ArrayList<Human> children)
            {
                this.name = name;
                this.age = age;
                this.sex = sex;
                this.children = children;
            }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
