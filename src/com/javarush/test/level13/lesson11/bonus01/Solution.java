package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<Integer> numList = new ArrayList<Integer>();
        while (true)
        {
            String str = file.readLine();
            if (null == str) break;
            int num = Integer.parseInt(str);
            if (num % 2 == 0) numList.add(num);
        }

        numList = sort(numList);
        for (int elem : numList)
            System.out.println(elem);
    }


    public static List<Integer> sort(List<Integer> numList)
    {
        for (int i = 0; i < numList.size(); i++)
        {
            for (int j = 0; j < numList.size(); j++)
            {
                if(numList.get(i) < numList.get(j)){
                    numList.set(i, numList.get(i)+numList.get(j));
                    numList.set(j, numList.get(i)-numList.get(j));
                    numList.set(i, numList.get(i)-numList.get(j));
                }
            }
        }
        return numList;
    }
}

