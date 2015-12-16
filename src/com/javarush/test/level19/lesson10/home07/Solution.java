package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileOne = args[0];
        String fileTwo = args[1];

        BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(fileOne)));
        FileOutputStream fileOut = new FileOutputStream(fileTwo);

        boolean first = true;
        while (fileIn.ready()){
            String line = fileIn.readLine();
            String[] lineSp = line.split(" ");
            for(String el: lineSp){
                if(el.length() > 6&&!first) fileOut.write((","+el).getBytes());
                else if(el.length() > 6){
                    first = false;
                    fileOut.write(el.getBytes());}
            }
        }

        fileOut.close();
        fileIn.close();
    }
}
