package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len)
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.


Требования:
1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу
    проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором
    данные для записи должны записываться в fileWriter и дублироваться в консоль.
4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны
    записываться в fileWriter и дублироваться в консоль.
5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи
    должны записываться в fileWriter и дублироваться в консоль.
6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором
    данные для записи должны записываться в fileWriter и дублироваться в консоль.
7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи
    должны записываться в fileWriter и дублироваться в консоль.
8. Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же
    метод поля fileWriter.
*/

import java.io.*;

public class FileConsoleWriter
{
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName,boolean append) throws IOException
    {
        fileWriter = new FileWriter(fileName,append);
    }

    public FileConsoleWriter(String fileName) throws IOException
    {
        //super(fileName);
        fileWriter = new FileWriter(fileName);
        //this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        //super(fileName, append);
        fileWriter = new FileWriter (file,append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        //super(file);
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        //super(fd);
        fileWriter = new FileWriter(fd);
    }


    public void write(char[] cbuf, int off, int len) throws IOException
    {
        fileWriter.write(cbuf, off, len);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        osw.write(cbuf,off,len);
        osw.close();
    }


    public void write(int c) throws IOException
    {
        //super.write(c);
        fileWriter.write(c);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        osw.write(String.valueOf(c));
        osw.close();
    }

    public void write(String str) throws IOException
    {
        //super.write(str);
        fileWriter.write(str);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        osw.write(str);
        osw.close();
    }

    public void write(String str, int off, int len) throws IOException
    {
        //super.write(str, off, len);
        fileWriter.write(str,off,len);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        osw.write(str,off,len);
        osw.close();
    }

    public void write(char[] cbuf) throws IOException
    {
        //super.write(cbuf);
        fileWriter.write(cbuf);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        osw.write(cbuf);
        osw.close();
    }

    public void close() throws IOException
    {
        //super.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fcw = new FileConsoleWriter("d:/o.txt");
        fcw.write(135);
    }
}
