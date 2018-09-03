package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/* 
Генератор паролей

Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным
паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Сформируем строку из 8 маленьких букв
        StringBuilder sb = new StringBuilder();
        // Для соблюдения условия добавляем по разу каждый тип символов
        Random random = new Random();
        sb.append((char)(random.nextInt(26) + 97));
        sb.append((char)(random.nextInt(10) + 48));
        sb.append((char)(random.nextInt(26) + 65));
        // Дальше добавим еще 5 псевдорандомных символа
        for (int i = 0; i < 5; i++)
        {
            switch (random.nextInt(3))
            {
                case 0 : sb.append((char)(random.nextInt(26) + 97)); break;
                case 1 : sb.append((char)(random.nextInt(10) + 48)); break;
                case 2 : sb.append((char)(random.nextInt(26) + 65)); break;
            }
        }
        // Зашафлим полученную строку
        Collections.shuffle(Arrays.asList(sb.toString().getBytes()));

        baos.write(sb.toString().getBytes());
        return baos;
    }
}