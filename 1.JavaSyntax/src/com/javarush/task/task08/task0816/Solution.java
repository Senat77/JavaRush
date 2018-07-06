package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Buba",df.parse("AUGUST 23 1977"));
        map.put("Goga2",df.parse("SEPTEMBER 4 1963"));
        map.put("Lolo3",df.parse("JULY 23 1977"));
        map.put("Goga3",df.parse("SEPTEMBER 4 1963"));
        map.put("Lolo4",df.parse("JULY 23 1977"));
        map.put("Goga12",df.parse("SEPTEMBER 4 1963"));
        map.put("Lolo12",df.parse("JULY 23 1977"));
        map.put("Goga23",df.parse("SEPTEMBER 4 1963"));
        map.put("Lolo23",df.parse("JULY 23 1977"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();
        /*
        for (Map.Entry<String,Date> pair : map.entrySet())
        {
            Date date = pair.getValue();
            System.out.println(date.getMonth());
            if(date.getMonth() > 5 && date.getMonth() < 9)
                map.remove(pair.getKey());
        }
        */
        while(iterator.hasNext())
        {
            Map.Entry<String,Date> pair =  iterator.next();
            int month = pair.getValue().getMonth();
            //System.out.println(month);
            if(month > 4 && month < 8)
                iterator.remove();
        }
    }

    public static void main(String[] args) throws ParseException {
        HashMap<String ,Date> map = createMap();
        removeAllSummerPeople(map);
    }
}
