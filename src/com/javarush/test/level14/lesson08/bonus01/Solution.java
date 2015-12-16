package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

        try
        {
            List<Number> list = new LinkedList<Number>();
            list.get(4);
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new SQLException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            InputStream d = new FileInputStream("fff");
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new NullPointerException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.close();
            reader.readLine();
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            new URL("ddd");
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            Stack<Integer> g = new Stack();
            for(int i = 0; i <= Integer.MAX_VALUE; i++){
                g.peek();
            }
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new InvalidObjectException("d");
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new ParseException("fff",5);
        }catch (Exception e){
            exceptions.add(e);
        }
    }
}
