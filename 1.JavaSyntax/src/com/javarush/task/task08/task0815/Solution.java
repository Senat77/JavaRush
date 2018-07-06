package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей по принципу
«Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> hm = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0)
                hm.put("Bobo"+i,"M");
            else
                hm.put("Bubu"+i,"W");
        }
        return hm;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int res = 0;
        for (Map.Entry<String,String> elem : map.entrySet()) {
            if(name.equals(elem.getValue()))
                res++;
        }
        return res;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int res = 0;
        for (Map.Entry<String,String> elem : map.entrySet()) {
            if(lastName.equals(elem.getKey()))
                res++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
