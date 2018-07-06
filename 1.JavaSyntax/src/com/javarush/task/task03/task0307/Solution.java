package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zergs[] = new Zerg[10];
        Protoss prots[] = new Protoss[5];
        Terran ters[] = new Terran[12];

        for(int i=0;i<10;i++)
        {
            zergs[i] = new Zerg();
            zergs[i].name = "Zerg" + i;
        }

        for(int i=0;i<5;i++)
        {
            prots[i] = new Protoss();
            prots[i].name = "Protoss" + i;
        }

        for(int i=0;i<12;i++)
        {
            ters[i] = new Terran();
            ters[i].name = "Terran" + i;
        }
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
