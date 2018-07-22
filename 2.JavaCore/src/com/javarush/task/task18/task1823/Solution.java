package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь
resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while(true)
        {
            str = br.readLine();
            if("exit".equals(str))
                break;
            ReadThread rt = new ReadThread(str);
            rt.start();
        }
        br.close();
    }

    public static class ReadThread extends Thread
    {
        String fileName;

        public ReadThread(String fileName)
        {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут

        public void task() throws IOException
        {
            FileInputStream fis;

            fis = new FileInputStream(fileName);

            byte[] arr = new byte[fis.available()];
            fis.read(arr);
            fis.close();

            // Находим самый частовстречающийся символ
            HashMap<Byte,Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++)
            {
                if(map.containsKey(arr[i]))
                {
                    map.replace(arr[i],map.get(arr[i])+1);
                }
                else
                {
                    map.put(arr[i],1);
                }
            }

            byte key = 0;
            int value = 0;
            for (Map.Entry<Byte,Integer> e : map.entrySet())
            {
                if(e.getValue() > value)
                {
                    value = e.getValue();
                    key = e.getKey();
                }
            }

            resultMap.put(this.fileName,(int)key);
            //System.out.println(this.fileName + " " + (char)key);
        }

        @Override
        public void run()
        {
            //super.run();
            //try
            //{
                try
                {
                    this.task();
                }
                catch (IOException e) {}
            //}
            //catch (FileNotFoundException e1) {}
        }
    }
}
