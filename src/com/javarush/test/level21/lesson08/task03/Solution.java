package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args)
    {
        A a = new A(13, 91);
        A ca = null;
        C c = new C(13,91,"Hi");
        C cc = null;

        try{
            ca = a.clone();
            cc = c.clone();

        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(ca);

        System.out.println(c);
        System.out.println(cc);

        System.out.println(a.getI());
        System.out.println(ca.getI());
        System.out.println(a.getJ());
        System.out.println(ca.getJ());

    }

    public static class A implements Cloneable{
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException
        {
            return new A(getI(), getJ());
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected A clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable{

        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException
        {
           return new C(getI(),getJ(),getName());
        }
    }
}
