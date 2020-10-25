package ru.levelup.homework.lambda;

import lombok.Data;

import java.util.*;
@Data

public class UniqueExcersices {

    void uniqueEx(List<Task> list){

        String[] array = list.stream().map(x-> x.getTitle() + " " + x.getType()).distinct().toArray(String[]::new);


        for(String str: array){
            System.out.println(str);
        }


    }

}


