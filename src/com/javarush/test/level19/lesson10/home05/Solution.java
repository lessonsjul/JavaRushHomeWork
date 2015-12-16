package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileOne = args[0];
        String fileTwo = args[1];

        FileReader fileIn = new FileReader(fileOne);
        FileWriter fileOut = new FileWriter(fileTwo);

        String data = "";
        while (fileIn.ready()){
            char l = (char)fileIn.read();
            data += l;
        }

        String[] dataSp = data.split(" ");

        for(String el: dataSp){
            Pattern pattern = Pattern.compile("\\p{Digit}");
            Matcher matcher = pattern.matcher(el);
            if(matcher.find())
            {
                fileOut.write(el + " ");
            }
        }

        fileOut.close();
        fileIn.close();
    }
}
