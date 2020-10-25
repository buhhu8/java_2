package ru.levelup.homework.lambda;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAllExcercisesReading {

    public void FindAll(List<Task> list){

        Collection<Task> task = list.stream().filter(x->x.getType().equals(TaskType.Reading)).sorted((o2, o1) -> -o1.getCreatedOn().compareTo(o2.getCreatedOn())).collect(Collectors.toList());
        System.out.println(task);

    }

}
