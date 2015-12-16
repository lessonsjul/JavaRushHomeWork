package com.javarush.test.level12.lesson12.home06;

/* Fly, Run, Climb для классов Cat, Dog, Tiger, Duck
1. Внутри класса Solution создай интерфейс public interface Fly(летать) с методом void fly().
2. Внутри класса Solution создай интерфейс public interface Climb(лазить по деревьям) с методом void climb().
3. Внутри класса Solution создай интерфейс public interface Run(бегать) с методом void run().
4. Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
5. Добавь интерфейсы классам Cat(кот), Dog(собака), Tiger(тигр), Duck(Утка).
*/

public class Solution {

    public class Cat implements Climb, Run{

        @Override
        public void climb()
        {
            System.out.println("Кот лезет");
        }

        @Override
        public void run()
        {
            System.out.println("Кот бежит");
        }
    }

    public class Dog implements Run{
        @Override
        public void run()
        {
            System.out.println("Собака бежит");
        }
    }

    public class Tiger extends Cat implements Run, Climb{
    }

    public class Duck implements Fly, Run {
        @Override
        public void fly()
        {
            System.out.println("Утка летит");
        }

        @Override
        public void run()
        {
            System.out.println("Утка бежит");
        }
    }

    public interface Fly{
        void fly();
    }

    public interface Climb{
        void climb();
    }
    public interface Run{
        void run();
    }
}

