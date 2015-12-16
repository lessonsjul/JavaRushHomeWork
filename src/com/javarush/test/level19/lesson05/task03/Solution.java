package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(reader.readLine()));

        List<String> lines = new ArrayList<>();
        while (fileIn.ready()){
            String line = fileIn.readLine();
            String[] split = line.split(" ");
            lines.addAll(Arrays.asList(split));
        }

        for(String el: lines){
            try{
                Integer.parseInt(el);
                fileOut.write(el + " ");
            }catch (Exception e){}
        }

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
