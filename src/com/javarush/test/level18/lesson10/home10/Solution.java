package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> result = new TreeMap<>();

        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        String nameNewFile = null;

        String fileName;
            while (!"end".equals(fileName = reader.readLine()))
            {
                String[] splitedName = fileName.split(Pattern.quote("."));
                String lastEl = splitedName[splitedName.length-1];

                int num = Integer.parseInt(lastEl.substring(4));
                if(nameNewFile == null && num == 1){
                    String path = new File(fileName).getPath();
                    nameNewFile = path.substring(0,path.length()-6);
                }
                result.put(num, fileName);
            }

        fileOut = new FileOutputStream(nameNewFile);

        for(String el: result.values()){

            fileIn = new FileInputStream(el);

            byte[] buff = new byte[fileIn.available()];

            while (fileIn.available() > 0)
            {
                fileIn.read(buff);
                fileOut.write(buff);
            }
            fileIn.close();
        }

        reader.close();
        fileOut.close();
    }
}
