package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen
{
    private int egs = 30;

    public int getCountOfEggsPerMonth(){
        return egs;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - "+ Country.UKRAINE + ". Я несу " + egs + " яиц в месяц.";
    }
}
