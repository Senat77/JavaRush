package com.javarush.task.task20.task2027;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* 
Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать статический класс Word.
3. Класс Solution не должен содержать статические поля.
4. Метод detectAllWords должен быть статическим.
5. Метод detectAllWords должен быть публичным.
6. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
*/
public class Solution
{
    public static void main(String[] args)
    {
        /*
        int[][] crossword = new int[][]
        {
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> w = detectAllWords(crossword, "home", "same","kerpo");
        */
        int[][] crossword = new int[][]{
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'},
        };
        List<Word> w = detectAllWords(crossword,"one");
        System.out.println(w.size());
        for (int i = 0; i < w.size(); i++)
        {
            System.out.println(w.get(i).toString());
        }
        /*
        Ожидаемый результат
        home - (5, 3) - (2, 0)
        same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        ArrayList<Word> list = new ArrayList<>();
        // Массив направлений
        int[][] direction = new int [][]
        {
          {0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}
        };
        // По всем словам массива искомых слов :
        for (int i = 0; i < words.length; i++)
        {
            String s = words[i];
            // Ищем первую букву
            for (int x = 0; x < crossword[0].length; x++)
            {
                for (int y = 0; y < crossword.length; y++)
                {
                    if (crossword[y][x] == s.charAt(0))
                    {
                        // Найдена первая буква , сверка слова во всех направлениях
                        //int startX = x;
                        //int startY = y;
                        String fromMatrix;
                        Word w = null;
                        // По всему массиву поиска
                        for (int dir = 0; dir < 8; dir++)
                        {
                            int dx = direction[dir][0];
                            int dy = direction[dir][1];
                            fromMatrix = s.substring(0,1);
                            try
                            {
                                for (int l = 1; l < s.length(); l++)
                                {
                                    fromMatrix += (char)(crossword[y + dy*l][x + dx*l]);
                                }
                                if (s.equals(fromMatrix))
                                {
                                    // Нашли, добавляем в список
                                    w = new Word(s);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x + dx * (s.length()-1),y + dy * (s.length()-1));
                                    list.add(w);
                                }
                            } catch (ArrayIndexOutOfBoundsException e)
                            {

                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
