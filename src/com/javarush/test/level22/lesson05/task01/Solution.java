package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString(" 1 1 1 1 1 "));
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        String result = null;
        if(string == null) throw new TooShortStringException();

        int indexFirst = string.indexOf(" ");
        int indexSecond = string.indexOf(" ", indexFirst+1);
        int indexThird = string.indexOf(" ", indexSecond+1);
        int indexFour = string.indexOf(" ", indexThird+1);
        int indexFive = string.indexOf(" ", indexFour + 1);

        if(indexFirst == -1 || indexFour == -1) throw new TooShortStringException();
        else if(indexFive == -1 && indexFour == string.length()-1) throw new TooShortStringException();
        else if(indexFive == -1) return result = string.substring(indexFirst+1, string.length());
        else return result = string.substring(indexFirst+1, indexFive);

    }

    public static class TooShortStringException extends Exception{
    }
}
