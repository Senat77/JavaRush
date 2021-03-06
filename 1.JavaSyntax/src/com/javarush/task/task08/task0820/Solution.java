package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog без конструктора или с конструктором без параметров.
2. Реализовать метод createCats, который должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, который должен возвращать множество с 3 собаками.
4. Реализовать метод join, который должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, который должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, который должен выводить на экран всех животных, которые в нем есть.
Каждое животное с новой строки


Требования:
1. Программа должна выводить текст на экран.
2. Внутри класса Solution должен быть public static классы Cat, Dog.
3. Метод createCats() класса Solution должен возвращать множество (Set) содержащее 4 кота.
4. Метод createDogs() класса Solution должен возвращать множество (Set) содержащее 3 собаки.
5. Метод join() класса Solution должен возвращать объединенное множество всех животных - всех котов и собак.
6. Метод removeCats() должен удалять из множества pets всех котов, которые есть в множестве cats.
7. Метод printPets() должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        //напишите тут ваш код
        for (int i = 0; i < 4; i++)
        {
            Cat c = new Cat();
            result.add(c);
        }
        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();
        //напишите тут ваш код
        for (int i = 0; i < 3; i++)
        {
            Dog d = new Dog();
            result.add(d);
        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet<Object> pets = new HashSet<>();
        for(Cat c : cats) pets.add(c);
        for(Dog d : dogs) pets.add(d);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        for(Cat c : cats)
        {
            Iterator<Object> iter = pets.iterator();
            while(iter.hasNext())
            {
                if(c.equals(iter.next())) iter.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for(Object p : pets)
            System.out.println(p);
    }

    //напишите тут ваш код
    public static class Cat {public Cat() {}}
    public static class Dog {public Dog() {}}
}
