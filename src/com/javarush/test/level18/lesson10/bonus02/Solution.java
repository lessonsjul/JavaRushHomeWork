package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        if (args[0].equals("-c")&&args.length == 4)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            TreeSet<Integer> set = new TreeSet();
            set.add(0);

            String line = null;
            while ((line = file.readLine()) != null)
            {
                try
                {
                    set.add(Integer.parseInt(line.substring(0, 8).trim()));
                }
                catch (IndexOutOfBoundsException e){

                }
            }

            file.close();

            String productName = args[1];
            double price = Double.parseDouble(args[2]);
            int quantity = Integer.parseInt(args[3]);
            if(productName.length() > 30) productName = productName.substring(0,30);
            int nextId = set.last() + 1;

            BufferedWriter fileOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true)));

            String out = String.format("%-8d%-30s%-8.2f%-4d",nextId, productName, price, quantity);

            fileOut.newLine();
            fileOut.write(out);
            reader.close();
            fileOut.close();
        }
    }
}
