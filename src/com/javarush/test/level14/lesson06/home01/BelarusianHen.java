package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen
{
    private int egs = 10;

    public int getCountOfEggsPerMonth(){
        return egs;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - "+ Country.BELARUS + ". Я несу " + egs + " яиц в месяц.";
    }
}
