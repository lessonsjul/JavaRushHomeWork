package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream file = new FileInputStream(fileName);
        if(file.available() > 0)
        {
            byte[] buff = new byte[file.available()];
            file.read(buff);
            String text = new String(buff);

            StringBuilder leftText = new StringBuilder(text);

            while (true)
            {

                //find index of space and substring word
                int index = leftText.indexOf(" ");
                if (index == -1) break;
                String word = leftText.substring(0, index);
                String reverseWord = null;

                //reverse founded word
                if(word.length() > 1)
                {
                    reverseWord  = new StringBuilder(word).reverse().toString();
                }else{
                    reverseWord = word;
                }

                //delete from text founded word
                leftText = leftText.delete(0, index+1);

                //find index of reverse word at the left text
                int matchIndex = leftText.indexOf(reverseWord);
                if (matchIndex > -1)
                {
                    Pair pair = new Pair();
                    pair.first = word;
                    pair.second = String.valueOf(reverseWord);
                    result.add(pair);
                    leftText = leftText.delete(matchIndex, matchIndex + reverseWord.length()+1);
                }
            }
        }

        for(Pair element: result){
            System.out.println(element.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
