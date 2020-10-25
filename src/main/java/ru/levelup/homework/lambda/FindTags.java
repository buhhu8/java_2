package ru.levelup.homework.lambda;

import java.util.List;
import java.util.stream.Stream;

public class FindTags {

    void find( List<Task> list) {

        boolean isAll = list.stream().filter(x-> x.getType().equals(TaskType.Reading)).allMatch((s) -> s.getTags().contains("#Books"));
        System.out.println("Tag #Books is contained to all Reading " + isAll);

    }
}
