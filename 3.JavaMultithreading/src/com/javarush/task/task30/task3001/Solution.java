package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений

Реализуй логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit(),
из одной системы счисления (numerationSystem) в другую (expectedNumerationSystem).
Брось NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2.
Валидация для - number.getDigit() - целое не отрицательное.
Метод main не участвует в тестировании.


Требования:
1. Метод convertNumberToOtherNumerationSystem (Number, NumerationSystem), возвращающий тип Number, должен существовать.
2. Должно бросаться исключение NumberFormatException, если переданное число некорректно в заданной системе счисления.
3. Необходимо корректно реализовать метод convertNumberToOtherNumerationSystem - перевод числа в указанную систему
счисления.
4. Enum NumerationSystemType должен поддерживать интерфейс NumerationSystem.
5. В enum-е NumerationSystemType должно присутствовать 11 значений оснований систем счисления.
Основания: 2, 3, 4, 5, 6, 7, 8, 9, 10, 12 и 16.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumerationSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem)
    {
        //напишите тут ваш код
        BigInteger num10 = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        String resNumber = num10.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, resNumber);
        /*
        Number res = null;

        if(number.getNumerationSystem() == expectedNumerationSystem)
            return new Number(expectedNumerationSystem,number.getDigit());

        try
        {
            // Переводим систему счисления в int
            int systemCount = Integer.parseInt(number.getNumerationSystem().toString().substring(1));
            BigInteger bi = new BigInteger(String.valueOf(Integer.parseInt(number.getDigit(),systemCount)));
            // Переводим число в новую систему
            systemCount = Integer.parseInt(expectedNumerationSystem.toString().substring(1));
            res = new Number(expectedNumerationSystem,bi.toString(systemCount));
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

        return res;
        */
    }
}
