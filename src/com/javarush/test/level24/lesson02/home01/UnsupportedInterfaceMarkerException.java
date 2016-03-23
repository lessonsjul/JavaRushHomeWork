package com.javarush.test.level24.lesson02.home01;

public class UnsupportedInterfaceMarkerException extends Exception
{
    public UnsupportedInterfaceMarkerException()
    {
        super();
        System.out.println("It's my exception when param == null");
    }
}
