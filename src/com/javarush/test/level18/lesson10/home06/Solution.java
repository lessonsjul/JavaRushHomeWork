package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream file = new FileInputStream (args[0]);
        int[] symbols = new int[255];
        while (file.available() > 0){
            int el = file.read();
            symbols[el] = ++symbols[el];
        }


        for(int i = 0; i < symbols.length; i++){
            if(symbols[i]!= 0){
                System.out.println((char)i + " " + symbols[i]);
            }
        }

        file.close();

    }
}
