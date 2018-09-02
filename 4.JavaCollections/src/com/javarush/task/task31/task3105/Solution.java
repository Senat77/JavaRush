package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив

В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с
добавленным файлом.
Пользоваться файловой системой нельзя.


Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все
содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<ZipEntry, ByteArrayOutputStream> zipEntryMap = new HashMap<>();
        //В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry currentEntry;
            while ((currentEntry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[4096 * 1024];
                int count = 0;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while ((count = zis.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                zipEntryMap.put(currentEntry, byteArrayOutputStream);
            }
        }

        //В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]))) {
            //В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
            File newFile = new File(args[0]);
            ZipEntry newEntry = new ZipEntry("new/" + newFile.getName());
            zos.putNextEntry(newEntry);
            Files.copy(newFile.toPath(), zos);


            //В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
            for (Map.Entry<ZipEntry, ByteArrayOutputStream> pair : zipEntryMap.entrySet()) {
                if (!newEntry.getName().equals(pair.getKey().getName())) {
                    zos.putNextEntry(new ZipEntry(pair.getKey().getName()));
                    zos.write(pair.getValue().toByteArray());
                }
            }
        }


        /*
        args = new String[2];
        args[0] = "c:/temp/a.txt";
        args[1] = "c:/temp/result.zip";

        if (args.length < 2) return;

        boolean isFileExist = false;
        Path zipPath = Paths.get(args[1]);
        Path filePath = Paths.get(args[0]);
        Path zipEntryPath = Paths.get("new/" + filePath.toFile().getName());
        Map<ZipEntry,byte[]> zipMap = new HashMap<>();

        try(ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipPath)))
        {
            // Вычитываем содержимое
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null)
            {
                byte[] buffer = new byte[(int) zipEntry.getSize()];
                zis.read(buffer);
                if (zipEntry.getName().equals(filePath.getFileName().toString()))
                {
                    isFileExist = true;
                } else
                {
                    zipMap.put(zipEntry, buffer);
                }
            }
        }

        // Запись
        try(ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipPath)))
        {
            // Добавление нового файла
            if (!isFileExist)
            {
                zos.putNextEntry(new ZipEntry(zipEntryPath.toString()));
                Files.copy(filePath, zos);
                zos.closeEntry();
            }
            for (Map.Entry<ZipEntry, byte[]> entry : zipMap.entrySet())
            {
                zos.putNextEntry(entry.getKey());
                zos.write(entry.getValue());
                zos.closeEntry();
            }
        }

        /*
        String filePath = args[0];
        String zipPath = args[1];
        Map<ZipEntry, byte[]> zipMap = new HashMap<>();
        boolean isFileExists = false;

        final Path fileName = Paths.get(filePath);
        final Path newFileName = Paths.get("new" + File.separator + fileName);

        ZipInputStream zipFile = new ZipInputStream(new FileInputStream(fileName.toString()));
        ZipEntry curZipEntry;
        while ((curZipEntry = zipFile.getNextEntry()) != null) {
            byte[] buffer = new byte[(int) curZipEntry.getSize()];
            int dataLen = zipFile.read(buffer);
            if (dataLen != -1 && !curZipEntry.getName().equals(fileName)) {
                zipMap.put(curZipEntry, buffer);
            } else
                isFileExists = true;
        }
        zipFile.close();

        ZipOutputStream newZipFile = new ZipOutputStream(new FileOutputStream(zipPath));
        for (Map.Entry<ZipEntry, byte[]> entry : zipMap.entrySet()) {
            entry.getKey().setCompressedSize(-1);
            newZipFile.putNextEntry(entry.getKey());
            newZipFile.write(entry.getValue());
            newZipFile.closeEntry();
        }

        if (isFileExists) {
            newZipFile.putNextEntry(new ZipEntry(newFileName.toString()));

            FileInputStream newFileStream = new FileInputStream(filePath);
            byte[] buffer = new byte[newFileStream.available()];
            newFileStream.read(buffer);
            newFileStream.close();

            newZipFile.write(buffer);
        }
        newZipFile.closeEntry();
        newZipFile.close();
        */
    }
}
