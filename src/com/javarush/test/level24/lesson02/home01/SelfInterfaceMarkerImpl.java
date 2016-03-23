package com.javarush.test.level24.lesson02.home01;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{

    public SelfInterfaceMarkerImpl()
    {
    }

    public static void methodOne(){
        System.out.println("Method one");
    }

    public static String hello(String str){
        return "You want write this: " + str;
    }
}
