package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(String name)
    {
        super(name);
    }

    public SubSolution(String name, int age)
    {
        super(name, age);
    }

    protected SubSolution(int age)
    {
        super(age);
    }

    protected SubSolution(double salary)
    {
        super(salary);
    }

    protected SubSolution(String name, double salary)
    {
        super(name, salary);
    }

    SubSolution(Boolean doIt, String name)
    {
        super(doIt, name);
    }

    SubSolution(Boolean doIt, String name, int age)
    {
        super(doIt, name, age);
    }

    SubSolution(Boolean doIt, String name, int age, double salary)
    {
        super(doIt, name, age, salary);
    }

    private SubSolution(int age, double salary){
    }
    private SubSolution(String name, int age, double salary){}
    private SubSolution(Boolean doIt){
    }
}
