package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл

В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002


Требования:
1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят аргументами в
main, начиная со второго.
2. Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
3. Поток для чтения из архива должен быть закрыт.
4. Поток для записи в файл должен быть закрыт.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String resultFileName = args[0];

        String[] fileNamePart = Arrays.stream(args).skip(1).sorted().toArray(String[]::new);

        Vector<InputStream> inputStreamVector = new Vector<>();

        for (String str: fileNamePart)
            inputStreamVector.add(new FileInputStream(str));

        try(FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(inputStreamVector.elements())))
        {
            ZipEntry zipEntry;
            while((zipEntry = zipInputStream.getNextEntry()) != null)
            {
                streamTransfer(zipInputStream, fileOutputStream);
                zipInputStream.closeEntry();
                zipInputStream.closeEntry();
            }
        }

    }

    public static void streamTransfer(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer =new byte[1024];
        int countOfBytes;
        while ((countOfBytes = in.read(buffer))>0)
        {
            out.write(buffer, 0, countOfBytes);
            out.flush();
        }
    }
}