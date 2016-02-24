package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        String result = null;
        if(string == null) throw new TooShortStringException();

        int indexFirst = string.indexOf('\t');
        int indexSecond = string.indexOf('\t', indexFirst + 1);

        if(indexFirst == -1 || indexSecond == -1) throw new TooShortStringException();
        else if(indexFirst+1 == indexSecond) return result = "";
        else return result = string.substring(indexFirst+1,indexSecond);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
