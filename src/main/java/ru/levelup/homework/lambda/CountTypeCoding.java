package ru.levelup.homework.lambda;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CountTypeCoding {
    void countCoding(List<Task> list){

        Long count = list.stream().filter(x-> x.getType().equals(TaskType.Coding)).count();
        System.out.println(count);
    }
}
