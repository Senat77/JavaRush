package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfatherName = reader.readLine();
        Cat catGrandfather = new Cat(grandfatherName);

        String grandmotherName = reader.readLine();
        Cat catGrandmother = new Cat(grandmotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName,catGrandfather,null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName,null,catGrandmother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName,catFather,catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather,catMother);

        System.out.println(catGrandfather);
        System.out.println(catGrandmother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentF;
        private Cat parentM;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat fParent, Cat mParent) {
            this.name = name;
            this.parentM = mParent;
            this.parentF = fParent;
        }

        @Override
        public String toString() {
            String res = "Cat name is " + name;
            if (parentM == null)
                res += ", no mother ";
            else
                res += ", mother is " + parentM.name;
            if (parentF == null)
                res += ", no father ";
            else
                res += ", father is " + parentF.name;
            return res;
        }
    }

}
