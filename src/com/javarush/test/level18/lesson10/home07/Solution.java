package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args.length < 1) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        int id = Integer.parseInt(args[0]);

        String line = null;
        while ((line = file.readLine()) != null){
            String[] arr = line.split(" ");
            if(Integer.parseInt(arr[0]) == id){
                double price = Double.parseDouble(arr[arr.length - 2]);
                int quantity = Integer.parseInt(arr[arr.length - 1]);
                String prodName = "";
                for(int i = 1; i < arr.length - 2; i++)
                    prodName = prodName + arr[i] + " ";

                System.out.println(id + " " + prodName.trim() + " " + price + " " + quantity);
            }

        }

        reader.close();
        file.close();
    }
}
