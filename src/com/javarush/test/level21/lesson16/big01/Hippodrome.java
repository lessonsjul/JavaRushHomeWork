package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome
{
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();


        Horse horse1 = new Horse("Lola", 3, 0);
        Horse horse2 = new Horse("Gibon", 3, 0);
        Horse horse3 = new Horse("Fred", 3, 0);

        List<Horse> horseList = game.getHorses();

        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);

        game.run();
        game.printWinner();
    }

    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for(int i = 1; i < 101; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse: horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse: horses){
            horse.print();
        }

        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winner = null;
        double maxdist = 0;
        for(Horse horse: horses){
            if(horse.getDistance() > maxdist) {
                maxdist = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() +"!");
    }
}
