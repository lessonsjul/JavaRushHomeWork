package com.javarush.test.level12.lesson12.home05;

/* Что это? «Кот», «Тигр», «Лев», «Бык», «Корова», «Животное»
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «Корова», «Животное».
Замечание: постарайся определять тип животного как можно более точно.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o)
    {
        //напишите тут ваш код
        return o.toString();
    }

    public static class Cat  extends Animal   //<--Классы наследуются!!
    {
       String name = "Кот";

        @Override
        public String toString()
        {
            return this.name;
        }
    }

    public static class Tiger  extends Cat
    {
        String name = "Тигр";

        @Override
        public String toString()
        {
            return this.name;
        }
    }

    public static class Lion  extends Cat
    {
        String name = "Лев";

        @Override
        public String toString()
        {
            return this.name;
        }
    }

    public static class Bull  extends Animal
    {
        String name = "Бык";

        @Override
        public String toString()
        {
            return this.name;
        }
    }

    public static class Cow  extends Animal
    {
        String name = "Корова";

        @Override
        public String toString()
        {
            return this.name;
        }
    }

    public static class Animal
    {
        String name = "Животное";

        @Override
        public String toString()
        {
            return this.name;
        }
    }
}
