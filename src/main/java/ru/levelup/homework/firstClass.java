package ru.levelup.homework;

import ru.levelup.homework.ReflectionClass;

import java.sql.SQLOutput;

@ReflectionClass
public class firstClass {
    Integer i;
    String a;
    Double c;

    public firstClass(){
        i=2;
        a="firstClass";
        c=3.0;
    }
    @Override
    public String toString() {
    return  "firstClass to string";

    }
    public void run(){
        System.out.println("Run");
    }
}
