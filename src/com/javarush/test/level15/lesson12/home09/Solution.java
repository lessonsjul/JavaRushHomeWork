package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        reader.close();

        //отделяем от полученной строки все параметры, которые идут после ?
        String afterQuestion = input.substring(input.indexOf("?") + 1);

        //заменяю все & на ?
        afterQuestion = afterQuestion.replaceAll("&", "?");
        String[] parameters = afterQuestion.split("(\\?+)");

        ArrayList<String> matches = new ArrayList<String>();

        //перебираем все параметры
        for(String elem: parameters){
            if(!elem.equals(""))
            {
                Pattern obj = Pattern.compile("^obj=.*");


                if (obj.matcher(elem).find()) //если параметер obj
                {
                    matches.add(elem.substring(elem.indexOf("=") + 1)); //добавляем его значение в массив
                    System.out.print(elem.substring(0, elem.indexOf("=")) + " ");

                } else if (elem.contains("=")) //если параметер имеет значение
                {
                    System.out.print(elem.substring(0, elem.indexOf("=")) + " "); //выводим только название параметра
                } else
                {
                    System.out.print(elem + " ");
                }
            }
        }

        System.out.println();

        //Если присутствует параметр obj, то передаем его значение в нужный метод alert
        if(matches.size() != 0){
            for(String elem2: matches){
                try{
                    double d = Double.parseDouble(elem2);
                    alert(d);
                }catch (NumberFormatException e){
                    alert(elem2);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
