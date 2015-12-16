package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileIn = new FileInputStream(args[1]);
        FileOutputStream filOut = new FileOutputStream(args[2]);

        if(args.length < 3) return;
        if(args[0].equals("-e")){
            while (fileIn.available() > 0){
                int count = fileIn.read();
                if(count == 0xff) count = 0x00;
                else count++;
                filOut.write(count);
            }
        }
        else if(args[0].equals("-d")){
            while (fileIn.available() > 0){
                int count = fileIn.read();
                if(count == 0x00) count = 0xff;
                else count--;
                filOut.write(count);
            }
        }

    }
}
