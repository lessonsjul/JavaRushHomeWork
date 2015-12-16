package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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

        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        Map<String, Double> data = new TreeMap<>();

        while (file.ready()){
            String[] line = file.readLine().split(" ");
            if(data.containsKey(line[0])){
                double d = data.get(line[0]);
                d = d + Double.parseDouble(line[1]);
                data.put(line[0],d);

            }else {
                data.put(line[0], Double.parseDouble(line[1]));
            }
        }

        for(Map.Entry<String, Double> pair: data.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        file.close();
    }
}
