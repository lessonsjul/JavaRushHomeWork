package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        FileReader fileOne = new FileReader(reader.readLine());
        FileWriter fileTwo = new FileWriter(reader.readLine());

        while (fileOne.ready())
        {
            fileOne.skip(1);
            int count = fileOne.read();
            fileTwo.write(count);
        }

        reader.close();
        fileOne.close();
        fileTwo.close();
    }
}
