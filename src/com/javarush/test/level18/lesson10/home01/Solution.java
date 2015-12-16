package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        FileInputStream file = new FileInputStream(args[0]);

        byte[] buffer = new byte[file.available()];
        while (file.available() > 0){
            int count = file.read(buffer);
        }
        long count = 0;
        for(byte el: buffer){
            if(el > 64 && el < 123)
                count++;
        }

        System.out.println(count);

        file.close();
    }
}
