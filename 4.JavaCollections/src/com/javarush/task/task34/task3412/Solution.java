package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс

В Intellij IDEA Alt+Ctrl+Shift+S -> Global Libraries -> New Global Library -> From Maven...

В строке поиска в открывшемся окне укажи: org.slf4j:slf4j-api:1.7.23 -> Поиск (Shift+Enter)
Укажи куда скачать библиотеку логирования.
Выбрери к какому модулю проекта подключить библиотеку slf4j-api: нужно выбрать
4.JavaCollections -> OK
Apply -> OK.

Посмотри где бы ты в классе Solution применил какой уровень логирования?

В класс Solution нужно добавить вызовы методов уровня:
error - 1 раз;
debug - 6 раз - используй при изменениях значений полей класса;
trace - 4 раза - используй для отслеживания пути выполнения програмы;
Сообщения в логах старайся писать информативные.
Остальной код не изменяй.


Требования:
1. В классе Solution должно существовать приватное статическое финальное поле logger.
2. Добавь логирование уровня error один раз.
3. Добавь логирование уровня debug шесть раз.
4. Добавь логирование уровня trace четыре раза.

*/

public class Solution
{
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3)
    {
        logger.debug("Change object properties : value1, value2, value3");
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args)
    {

    }

    public void calculateAndSetValue3(long value)
    {
        logger.trace("calculateAndSetValue3().value");
        value -= 133;
        if (value > Integer.MAX_VALUE)
        {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("calculateAndSetValue3. value1=" + value1);
            //logger.trace("calculateAndSetValue3().value > Integer.MAX_VALUE");
        }
        else
        {
            value1 = (int) value;
            logger.debug("calculateAndSetValue3. value1=" + value1);
            //logger.trace("calculateAndSetValue3().value <= Integer.MAX_VALUE");
        }
    }

    public void printString()
    {
        if (value2 != null)
        {
            System.out.println(value2.length());
        }
        logger.trace("printString().value2=null");
    }

    public void printDateAsLong()
    {
        if (value3 != null)
        {
            System.out.println(value3.getTime());
        }
        logger.trace("printDateAsLong().value3=null");
    }

    public void divide(int number1, int number2)
    {
        logger.trace("Оно тут нафиг не нужно");
        try
        {
            System.out.println(number1 / number2);
        }
        catch (ArithmeticException e)
        {
            logger.error("Method divide.ArithmeticException.number1=" + number1 + ".number2=" + number2);
        }
    }

    public void setValue1(int value1)
    {
        logger.debug("setValue1().value1=" + value1);
        this.value1 = value1;
    }

    public void setValue2(String value2)
    {
        logger.debug("setValue2().value2=" + value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3)
    {
        logger.debug("setValue3().value3=" + value3);
        this.value3 = value3;
    }
}
