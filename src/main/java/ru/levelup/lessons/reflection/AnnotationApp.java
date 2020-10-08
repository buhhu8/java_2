package ru.levelup.lessons.reflection;

import ru.levelup.lessons.reflection.annotation.RandomIntAnnotationProcessor;

public class AnnotationApp {

    public static void main(String[] args) {
        RandomIntAnnotationProcessor processor = new RandomIntAnnotationProcessor();
        Watch watch = processor.initializeWatch();

        System.out.println(watch.getWeight()+ " " + watch.getLength());

        Watch watch2 = processor.initializeWatch();
        System.out.println(watch2.getWeight()+ " "+ watch2.getLength());
    }
}
