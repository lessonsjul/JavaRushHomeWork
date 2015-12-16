package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{

        FileInputStream file = new FileInputStream(args[0]);
        int length = file.available();
        int count = 0;

        while (file.available() > 0){
            int el = file.read();
            if(el == 32)
                count++;
        }

        System.out.format("%.2f",((float)count/length)*100);


        file.close();
    }
}
