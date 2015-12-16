package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file = new FileInputStream(reader.readLine());
        FileOutputStream fileOut = new FileOutputStream(reader.readLine());

        byte[] buff = new byte[file.available()];

        file.read(buff);

        String text = new String(buff);

        text = text.replaceAll(Pattern.quote("."), "!");

        fileOut.write(text.getBytes());
        reader.close();
        file.close();
        fileOut.close();
    }
}
