package com.gfg.oop.polymorphism.compiletime;

public class ExampleOverloading
{
    public static void main(String args[])
    {
        DisplayOverloading obj = new DisplayOverloading();
        obj.disp('a');
        obj.disp('a',10);
    }
}