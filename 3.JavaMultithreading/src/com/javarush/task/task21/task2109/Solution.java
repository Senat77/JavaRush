package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
Разреши клонировать класс А
Запрети клонировать класс B
Разреши клонировать класс C
Не забудь о методах equals и hashCode!


Требования:
1. Класс A должен поддерживать интерфейс Cloneable.
2. Класс B должен быть потомком класса A.
3. При объявлении класса B не должно быть явно указано implements Cloneable.
4. Метод clone в классе B должен быть переопределен таким образом, чтобы при попытке клонирования объекта класса B
    возникало исключение CloneNotSupportedException.
5. Класс C должен быть потомком класса B.
6. Клонирование объектов класса C должно завершаться успешно.
*/
public class Solution
{
    public static class A implements Cloneable
    {
        private int i;
        private int j;

        public A(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A
    {
        private String name;

        public B(int i, int j, String name)
        {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B
    {
        public C(int i, int j, String name)
        {
            super(i, j, name);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(getI(),getJ(),getName());
        }

        @Override
        public boolean equals(Object obj)
        {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            C newC = new C(this.getI(),this.getJ(),this.getName());
            return newC;
        }
    }

    public static void main(String[] args)
    {

    }
}
