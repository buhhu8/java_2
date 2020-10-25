package ru.levelup.homework.lambda;

import org.hibernate.mapping.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllTitleInOneRow {

    void findAllTitle(List<Task> list){

        String strAllTitle = list.stream().map(x -> x.getTitle()).collect(Collectors.joining("***"));
        System.out.println(strAllTitle);

    }

}
