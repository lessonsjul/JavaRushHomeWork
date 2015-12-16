package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        String fileName = args[0];


        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (reader.ready()){
            String[] lineSp = reader.readLine().split(" ");

            int day = Integer.parseInt(lineSp[lineSp.length - 3]);
            int month = Integer.parseInt(lineSp[lineSp.length - 2]);
            int year = Integer.parseInt(lineSp[lineSp.length - 1]);

            Date date = new SimpleDateFormat("dd MM yyyy").parse(day +" "+ month + " "+ year);

            String name = "";
            for(int i = 0; i <lineSp.length-3; i++){
                name += lineSp[i] + " ";
            }

            PEOPLE.add(new Person(name.trim(), date));
        }

        reader.close();
    }

}
