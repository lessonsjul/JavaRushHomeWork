package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream file1 = new FileInputStream(name);
        FileInputStream file2 = new FileInputStream(reader.readLine());

        byte[] buff1 = new byte[file1.available()];
        byte[] buff2 = new byte[file2.available()];
        while (file1.available() > 0 || file2.available() > 0){
            int count = 0;
            if(file1.available() != 0)
            {
                count = file1.read(buff1);
            }else if(file2.available() != 0){
                count = count + file2.read(buff2);
            }
        }

        FileOutputStream file = new FileOutputStream(name);
        file.write(buff2, 0, buff2.length);
        file.write(buff1, 0, buff1.length);

        file.close();
        file1.close();
        file2.close();
        reader.close();
    }
}
