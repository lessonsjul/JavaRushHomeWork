package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        testString.printSomething();

        String res = output.toString();

        System.setOut(console);

        String[] split = res.split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[2]);
        long compute = 0;
        if(split[1].equals("+")){
            compute = a+ b;
        }
        if(split[1].equals("-")){
            compute = a -b;
        }
        if(split[1].equals("*")){
            compute = a*b;
        }

        System.out.print(a +" " + split[1] + " " + b + " = " + compute);
    }

    public static class TestString {
        public void printSomething() {System.out.println("30 * 68 = ");}
    }
}

