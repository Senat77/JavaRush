package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используй наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().


Требования:
1. Метод main изменять нельзя.
2. Класс AmigoOutputStream должен наследоваться от класса FileOutputStream.
3. Класс AmigoOutputStream должен принимать в конструкторе обьект типа FileOutputStream.
4. Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать свое выполнение
    объекту FileOutputStream.
5. Метод close() должен сначала вызвать метод flush(), затем дописать текст, затем закрыть поток.
*/

public class AmigoOutputStream extends FileOutputStream
{
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fis;

    public static void main(String[] args) throws FileNotFoundException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream (FileOutputStream fis) throws FileNotFoundException
    {
        super(fileName);
        this.fis = fis;
    }

    /*
    public AmigoOutputStream(String name) throws FileNotFoundException
    {
        fis = new FileOutputStream(fileName);
    }


    public AmigoOutputStream(String name, boolean append) throws FileNotFoundException
    {
        super(name, append);
    }

    public AmigoOutputStream(File file) throws FileNotFoundException
    {
        super(file);
    }

    public AmigoOutputStream(File file, boolean append) throws FileNotFoundException
    {
        super(file, append);
    }

    public AmigoOutputStream(FileDescriptor fdObj)
    {
        super(fdObj);
    }
    */

    @Override
    public void write(int b) throws IOException
    {
        fis.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        fis.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        fis.write(b, off, len);
    }

    @Override
    public void close() throws IOException
    {
        fis.flush();
        fis.write("JavaRush © All rights reserved.".getBytes());
        fis.close();
    }

    @Override
    public FileChannel getChannel()
    {
        return fis.getChannel();
    }

    //@Override
    /*
    protected void finalize() throws IOException
    {
        fis.finalize();
    }
    */

    @Override
    public void flush() throws IOException
    {
        fis.flush();
    }

    @Override
    public int hashCode()
    {
        return fis.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return fis.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return fis.toString();
    }
}
