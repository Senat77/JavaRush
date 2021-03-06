package com.javarush.task.task20.task2009;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной.


Требования:
1. Класс ClassWithStatic должен существовать внутри класса Solution.
2. Класс ClassWithStatic должен быть статическим.
3. Класс ClassWithStatic должен быть публичным.
4. Класс ClassWithStatic должен поддерживать интерфейс Serializable.
*/
public class Solution
{
    public static class ClassWithStatic implements Serializable
    {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public static void serializeStatic (ObjectOutputStream oos) throws IOException
        {
            oos.writeUTF(staticString);
        }

        public static void deserializeStatic (ObjectInputStream  ois) throws IOException
        {
            staticString = ois.readUTF();
        }
    }

    public static void main(String[] args)
    {

    }
}
