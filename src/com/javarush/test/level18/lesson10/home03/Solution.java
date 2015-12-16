package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream file1 = new FileOutputStream(reader.readLine());
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());

        byte[] buff = new byte[file2.available() + file3.available()];
        while (file2.available() > 0 || file3.available() > 0){
            int count = 0;
            if(file2.available() != 0)
            {
                count = file2.read(buff);
            }else {
               count += file3.read(buff);
            }
            file1.write(buff, 0, count);
        }

        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
