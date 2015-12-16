package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = null;
        while (!(name = reader.readLine()).equals("exit"))
        {
            new ReadThread(name).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread
    {
        String fileName;

        public ReadThread(String fileName) throws IOException
        {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            try
            {
                FileInputStream file = new FileInputStream(this.fileName);

                if(file.available() == 0) return;

                Map<Integer, Integer> result = new HashMap<>();
                while (file.available() > 0)
                {
                    int data = file.read();

                    if(result.containsKey(data)){
                        int c = result.get(data);
                        result.put(data, ++c);
                    }
                    else{
                        result.put(data,1);
                    }
                }
                file.close();

                int maxCount = 0;
                int maxUsedByte = 0;
                for (Map.Entry<Integer, Integer> pair: result.entrySet())
                {
                    if(pair.getValue() > maxCount){
                        maxCount = pair.getValue();
                        maxUsedByte = pair.getKey();
                    }
                }

                resultMap.put(this.fileName, maxUsedByte);
            }
            catch (Exception e)
            {
            }
        }
    }
}
