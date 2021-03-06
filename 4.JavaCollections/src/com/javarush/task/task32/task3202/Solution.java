package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока

Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного
потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.


Требования:
1. Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.
2. Метод getAllDataFromInputStream (InputStream) должен возвращать StringWriter.
3. Метод getAllDataFromInputStream (InputStream) должен вернуть StringWriter, который содержит все данные из
переданного потока.
4. Возвращаемый объект ни при каких условиях не должен быть null.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:/temp/a.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException
    {
        StringWriter sw = new StringWriter();
        if(is == null)
            return sw;
        while(is.available() > 0)
        {
            int b = is.read();
            sw.write(b);
        }

        return sw;
    }
}