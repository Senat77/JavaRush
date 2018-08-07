package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/*
Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова
совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе getLine должен быть использован StringBuilder
3. Метод getLine должен возвращать пустую строку(пустой StringBuilder) в случае если ему не были переданы
    параметры(слова).
4. Все слова переданные в метод getLine должны быть включены в результирующую строку, если это возможно.
5. Вывод на экран должен соответствовать условию задачи.
6. Метод getLine не должен изменять переданные ему параметры(слова).
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
        ArrayList<String> list = new ArrayList<>();
        while (fr.ready())
            list.addAll(Arrays.asList(fr.readLine().split(" ")));

        String [] strs = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            strs[i] = list.get(i);
        }
        StringBuilder result = getLine(strs);
        System.out.println(result.toString());
        br.close();
        fr.close();
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length * words.length; i++) {
            ArrayList<String> array = new ArrayList<>(Arrays.asList(words));
            res.delete(0, res.length());

            char curFirstLetter = 0;
            char curLastLetter = 0;
            char resFirstLetter = 0;
            char resLastLetter = 0;
            int curArraySize = 0;
            boolean firstLapse = true;

            while (array.size() != 0) {
                if (array.size() == curArraySize) break;

                Collections.shuffle(array);

                curArraySize = array.size();
                Iterator<String> iterator = array.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    curFirstLetter = Character.toLowerCase(word.charAt(0));
                    curLastLetter = Character.toLowerCase(word.charAt(word.length() - 1));
                    if (res.length() > 0) {
                        resFirstLetter = Character.toLowerCase(res.charAt(0));
                        resLastLetter = Character.toLowerCase(res.charAt(res.length() - 1));
                    }

                    if (curLastLetter == resFirstLetter) {
                        res.insert(0, " ");
                        res.insert(0, word);
                        iterator.remove();
                    } else if (firstLapse || curFirstLetter == resLastLetter) {
                        if (!firstLapse) res.append(" ");
                        res.append(word);
                        iterator.remove();
                        firstLapse = false;
                    }
                }
            }

            if (array.size() == 0) break;
        }
        return res;
    }

    /*
    public static StringBuilder getLine(String... words)
    {
        if(words == null || words.length == 0) return new StringBuilder();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words).sort());
        while(!list.isEmpty())
        {
            if(sb.length() == 0)
            {
                sb.append(list.get(0));
                list.remove(0);
            }
            else
            {
                char lastChar = sb.charAt(sb.length() - 1);
                for(String e : list)
                {
                    if(lastChar == e.toLowerCase().charAt(0))
                    {
                        sb.append(" ").append(e);
                        list.remove(e);
                        break;
                    }
                }
            }
        }
        return sb;
    }
    */
}
