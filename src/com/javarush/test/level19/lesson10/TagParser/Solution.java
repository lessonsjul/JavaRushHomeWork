package com.javarush.test.level19.lesson10.TagParser;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>
text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        StringBuilder stringBuilder = new StringBuilder();
        while (file.ready()) {
            stringBuilder = stringBuilder.append(file.readLine());
        }

        String t = args[0];
        String text = stringBuilder.toString().replaceAll("\r\n", "");
        List<Integer> openTag =  new ArrayList<>();
        List<Integer> closeTag =  new ArrayList<>();

        String open = "<".concat(t);
        String closing = "</".concat(t);

        int len = t.length();
        int index1 = 0;

        while ((index1 != -1) && (index1 < text.length())) {
            index1 = text.indexOf(open,index1);
            int index2 = text.indexOf(closing,index1 + len);
            int k = index1 + len;
            if(index2 != -1)
            {
                while (text.substring(k, index2).contains(open))
                {
                    k = index2 + len;
                    index2 = text.indexOf(closing,k);
                }
            }
            if(index1 != -1 && index2 != -1){
                openTag.add(index1);
                closeTag.add(index2);
                index1+= len;
            }
        }

        for(int i =0; i <openTag.size();i++){
            System.out.println(text.substring(openTag.get(i),closeTag.get(i)+len+3));
        }
    }
}

