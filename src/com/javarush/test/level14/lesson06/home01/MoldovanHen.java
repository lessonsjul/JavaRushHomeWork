package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen
{
    private int egs = 20;

    public int getCountOfEggsPerMonth(){
        return egs;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - "+ Country.MOLDOVA + ". Я несу " + egs + " яиц в месяц.";
    }
}
