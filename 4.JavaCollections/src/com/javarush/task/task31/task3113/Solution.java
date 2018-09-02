package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/*
Что внутри папки?

Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.


Требования:
1. Метод main должен считывать путь к папке с консоли.
2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
3. Используй только классы и методы из пакета java.nio.
4. На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и
поддиректориях]".
5. На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и
поддиректориях]".
6. На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в
директории]".
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rootPath = br.readLine();

        if(!Files.isDirectory(Paths.get(rootPath)))
        {
            System.out.println(Paths.get(rootPath).getFileName().toAbsolutePath() + " - не папка");
            return;
        }

        AtomicInteger directories = new AtomicInteger();
        AtomicInteger files = new AtomicInteger();
        AtomicInteger size = new AtomicInteger();

        Files.walk(Paths.get(rootPath))
                .forEach(f -> {
                    if (Files.isDirectory(f)) directories.getAndIncrement();
                    else
                    {files.getAndIncrement();
                        try
                        {
                            size.getAndAdd((int)Files.size(f));
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

        System.out.println("Всего папок - " + directories.decrementAndGet());
        System.out.println("Всего файлов - " + files);
        System.out.println("Общий размер - " + size);
    }
}
