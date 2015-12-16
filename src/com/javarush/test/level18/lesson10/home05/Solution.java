package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileIn = new FileInputStream(reader.readLine());
        FileOutputStream fileOut = new FileOutputStream(reader.readLine());

        byte[] buff = new byte[fileIn.available()];
        while (fileIn.available() > 0)
        {
            fileIn.read(buff);
        }

        String dataFile = "";
        for (byte el: buff){
            dataFile = dataFile + String.valueOf((char)el);
        }

        String[] nums = dataFile.split(" ");
        dataFile = "";

        for(String el: nums){
            int d = Math.round(Float.parseFloat(el));
            dataFile = dataFile + String.valueOf(d) + " ";
        }

        fileOut.write(dataFile.trim().getBytes());

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
