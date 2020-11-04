package ru.levelup.homework.lambda;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testApp {

    public static void main(String[] args) {


        List<Task> list = new ArrayList<>();
        Set<String> tags= new HashSet<>();
        tags.add("#Books");

        FindAllExcercisesReading findAllExcercisesReading = new FindAllExcercisesReading();
        UniqueExcersices uniqueExcersices = new UniqueExcersices();
        FindFiveFirstReading findFiveFirstReading = new FindFiveFirstReading();
        CountTypeCoding countTypeCoding = new CountTypeCoding();
        AllTitleInOneRow allTitleInOneRow = new AllTitleInOneRow();
        FindTags findTags = new FindTags();
        Task task =(new Task("1", "Домашка", TaskType.Reading, LocalDate.now()));
        task.setTags(tags);
        list.add(task);
        task = new Task("2", "Домашка", TaskType.Coding, LocalDate.now());
        task.setTags(tags);
        list.add(task);
        task = new Task("3", "Домашка", TaskType.Writing, LocalDate.now());
        task.setTags(tags);
        list.add(task);
        task = new  Task("4", "Домашка", TaskType.Reading, LocalDate.of(2020,10,26));
        task.setTags(tags);
        list.add(task);
        task=new Task("5", "Чтение английского", TaskType.Reading, LocalDate.of(2020,10,25));
        task.setTags(tags);
        list.add(task);
        task = new Task("6", "Домашка", TaskType.Reading, LocalDate.of(2020,10,29));
        task.setTags(tags);
        list.add(task);
        task= new Task("7", "Домашка", TaskType.Reading, LocalDate.of(2020,10,28));
        task.setTags(tags);
        list.add(task);
        task = new Task("8", "Домашка", TaskType.Reading, LocalDate.of(2020,10,30));
        task.setTags(tags);
        list.add(task);

        //findAllExcercisesReading.FindAll(list);
         uniqueExcersices.uniqueEx(list);
      //  findFiveFirstReading.findFive(list);
       // countTypeCoding.countCoding(list);
      //  allTitleInOneRow.findAllTitle(list);
   //     findTags.find(list);

    }
}
