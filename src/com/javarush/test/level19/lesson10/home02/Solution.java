package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        Map<String, Double> data = new TreeMap<>();
        while (reader.ready()){

            String[] line = reader.readLine().split(" ");

            String name = line[0];
            double res = Double.parseDouble(line[1]);

            if(data.containsKey(name)){
                double d = data.get(name);
                d = d + res;
                data.put(name,d);
            }
            else data.put(name,res);
        }

        double max = 0;
        for(double el: data.values()){
            if(el> max) max = el;
        }

        for(Map.Entry<String,Double> pair: data.entrySet()){
            if(pair.getValue() == max){
                System.out.print(pair.getKey() + " ");
            }
        }
        reader.close();
    }
}
