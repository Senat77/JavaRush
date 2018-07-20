package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileWriter fw = new FileWriter(br.readLine());
        String curNumber = "";
        do
        {
            byte b;
            b = (byte)fis.read();
            if(b == ' ' || fis.available() == 0)
            {
                Double d = Double.parseDouble(curNumber);
                curNumber = String.format("%.0f ",d);
                fw.write(curNumber);
                curNumber = "";
            }
            else
            {
                curNumber += (char)b;
            }
        }
        while(fis.available() > 0);

        fis.close();
        fw.close();
    }
}
