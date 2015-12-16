package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        if(args.length < 2) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        if(args[0].equals("-u")&&args.length == 5){
            int idTarget = Integer.parseInt(args[1]);
            String productName = args[2];
            double price = Double.parseDouble(args[3]);
            int quantity = Integer.parseInt(args[4]);
            if(productName.length() > 30) productName = productName.substring(0,30);

            List<String> lines = new ArrayList<>();
            String line = null;
            while ((line = file.readLine()) != null)
            {
                lines.add(line);
            }

            file.close();
            int indexOfLine = 0;
            for(String el: lines){
                try{
                    int numId = Integer.parseInt(el.substring(0,8).trim());
                    if(numId == idTarget){
                        indexOfLine = lines.indexOf(el);
                        break;
                    }
                }catch (IndexOutOfBoundsException | NumberFormatException e){}
            }


            BufferedWriter fileOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

            String out = String.format("%-8d%-30s%-8.2f%-4d",idTarget, productName, price, quantity);
            lines.set(indexOfLine, out);

            for(String el: lines){
                fileOut.write(el);
                fileOut.newLine();
            }

            reader.close();
            fileOut.close();

        }else if(args[0].equals("-d")&&args.length == 2){
            int idTarget = Integer.parseInt(args[1]);

            List<String> lines = new ArrayList<>();
            String line = null;
            while ((line = file.readLine()) != null){
                lines.add(line);
            }

            for(String el: lines){
                try{
                    int numId = Integer.parseInt(el.substring(0,8).trim());
                    if(numId == idTarget){
                        lines.remove(el);
                        break;
                    }
                }catch (IndexOutOfBoundsException | NumberFormatException e){}
            }

            BufferedWriter fileOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

            for(String el: lines){
                fileOut.write(el);
                fileOut.newLine();
            }

            reader.close();
            fileOut.close();
        }
    }
}
