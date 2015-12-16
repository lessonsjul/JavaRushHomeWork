package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileIn = new FileReader(reader.readLine());

       String text = "";

        while (fileIn.ready())
        {
            char el = (char)fileIn.read();
            text += el;
        }

        text = text.toLowerCase();
        text = text.replaceAll("\\p{Punct}"," ");
        text = text.replaceAll("\\s"," ");

        String[] split = text.split(" ");

        int count = 0;
        for(String el: split){
            if(el.equals("world"))
                count++;
        }

        System.out.println(count);
        reader.close();
        fileIn.close();

    }
}
