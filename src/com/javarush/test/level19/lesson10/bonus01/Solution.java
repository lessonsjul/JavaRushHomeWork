package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();

        BufferedReader fileOne = new BufferedReader(new InputStreamReader(new FileInputStream(nameOne)));
        BufferedReader fileTwo = new BufferedReader(new InputStreamReader(new FileInputStream(nameTwo)));


        List<String> linesFromOne = new ArrayList<>();
        List<String> linesFromTwo = new ArrayList<>();
        while (fileOne.ready()){
            linesFromOne.add(fileOne.readLine());
        }
        while (fileTwo.ready()){
            linesFromTwo.add(fileTwo.readLine());
        }

        for(int i = 0; i < linesFromOne.size(); i++){
            if(linesFromOne.get(i).equals(linesFromTwo.get(i))&&!linesFromOne.get(i).equals("")){
                lines.add(new LineItem(Type.SAME,linesFromOne.get(i)));
                continue;
            }else if(!linesFromTwo.contains(linesFromOne.get(i)))
            {
                linesFromTwo.add(i, "");
                linesFromOne.add("");
                lines.add(new LineItem(Type.REMOVED,linesFromOne.get(i)));
            }else if(!linesFromOne.contains(linesFromTwo.get(i))){
                linesFromOne.add(i,"");
                linesFromTwo.add("");
                lines.add(new LineItem(Type.ADDED,linesFromTwo.get(i)));
            }
        }

        reader.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
