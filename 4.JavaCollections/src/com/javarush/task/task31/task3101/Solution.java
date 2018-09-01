package com.javarush.task.task31.task3101;

/* 
Проход по дереву файлов

1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который
будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2. Переименовать resultFileAbsolutePath в 'allFilesContent.txt' (используй метод FileUtils.renameFile, и, если
понадобится, FileUtils.isExist).
2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела файла
записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        /*
        args  = new String[2];
        // Путь к директории
        args[0] = "c:/temp/programs";
        // Полный путь существующего файла-результата
        args[1] = "c:/temp/result.txt";
        */

        ArrayList<File> fileList = new ArrayList<>();
        LinkedList<File> dirList = new LinkedList<>();

        dirList.add(new File(args[0]));

        checkDir(fileList,dirList);

        // Теперь запись, открываем файл-результат
        File resFile = new File(args[1]);
        File newFile = new File(resFile.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resFile,newFile);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
        // Прогоняем весь список файлов и записываем их в файл-результат
        for(File f : fileList)
        {
            // Открываем текущий файл
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            while(br.ready())
            {
                bw.write(br.readLine());
            }
            // В конце файла запишем перевод строки
            bw.write("\n");
            br.close();
        }
        bw.close();
    }

    private static void checkDir(ArrayList<File> fileList,LinkedList<File> dirList) throws IOException
    {
        // Пока список папок не пуст - сканируем
        while(!dirList.isEmpty())
        {
            // Забираем очередную папку
            File curDirFile = dirList.poll();
            // Получаем список файлов в этой папке
            File[] list = curDirFile.listFiles();
            if(list != null)
            {
                for (File file : list)
                {
                    if (file.isDirectory())
                    {
                        // Очередной файл из списка - это папка, добавляем в dirList
                        dirList.add(file);
                    }
                    else
                    {
                        // Файл, нужно обработать
                        if (file.length() <= 50)
                        {
                            // Добавляем в список
                            fileList.add(file);
                        }
                    }
                }
            }
        }

        // Файлы отобраны, список директорий пуст, сортируем по имени файла
        fileList.sort(new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                // Извлекаем имя файла из пути и сортируем по нему
                return(o1.getName().compareTo(o2.getName()));
            }
        });
        //System.out.println(fileList.toString());
    }
}
