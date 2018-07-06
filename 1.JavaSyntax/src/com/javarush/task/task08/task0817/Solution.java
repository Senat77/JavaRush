package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();
        map.put("F1","a");
        map.put("F2","b");
        map.put("F3","c");
        map.put("F4","c");
        map.put("F5","d");
        map.put("F6","f");
        map.put("F7","g");
        map.put("F8","b");
        map.put("F9","h");
        map.put("F10","c");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        HashMap<String,String> copy = new HashMap<>(map);
        Iterator<Map.Entry<String,String>> iterator = copy.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String,String> elem = iterator.next();
            int curSize = map.size();
            removeItemFromMapByValue(map, elem.getValue());
            int newSize = map.size();
            if (curSize - newSize == 1)
                map.put(elem.getKey(),elem.getValue());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String,String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
}
