package com.javarush.test.level23.lesson13.big01;

public class SnakeSection
{
    private int x;
    private int y;


    public SnakeSection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if(null == o) return false;
        if(!(o instanceof SnakeSection)) return false;

        SnakeSection snakeSection = (SnakeSection) o;

        if (x != snakeSection.x) return false;
        return y == snakeSection.y;

    }

    @Override
    public int hashCode()
    {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
