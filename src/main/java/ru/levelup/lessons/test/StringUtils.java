package ru.levelup.lessons.test;

public class StringUtils {

    public static boolean isEmpty(String value){
        return  value == null || value.trim().isEmpty();
    }

    public static void requiredNotEmpty(String value){
        if(isEmpty(value)){
            throw new IllegalArgumentException("Value must be is not empty");
        }
    }

}
