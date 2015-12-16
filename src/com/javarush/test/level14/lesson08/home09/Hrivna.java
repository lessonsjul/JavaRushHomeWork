package com.javarush.test.level14.lesson08.home09;

public class Hrivna extends Money
{
    private double amount;

    public Hrivna(double amount){
        super(amount);
    }

    public String getCurrencyName(){
        return "HRN";
    }
}
