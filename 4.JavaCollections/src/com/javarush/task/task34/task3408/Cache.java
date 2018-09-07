package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K,V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V value;
        if (cache.containsKey(key))
        {
            value = cache.get(key);
        }
        else
        {
            Constructor constructor = clazz.getConstructor(key.getClass());
            value = (V) constructor.newInstance(key);
            put(value);
        }
        return value;
    }

    public boolean put(V obj)
    {
        try
        {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            K key = (K) getKey.invoke(obj);
            cache.put(key, obj);
        }
        catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
        {
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}
