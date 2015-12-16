package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen
{
    private int egs = 40;

    public int getCountOfEggsPerMonth(){
        return egs;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - "+ Country.RUSSIA + ". Я несу " + egs + " яиц в месяц.";
    }
}
