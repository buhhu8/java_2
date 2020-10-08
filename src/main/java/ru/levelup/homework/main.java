package ru.levelup.homework;


import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {
        Class<?> watchClass;
        List list = getAllClassesFrom("ru.levelup.homework");
//        for(Object list1 : list){
//            System.out.println(list1.getClass().getAnnotations());
//        }
       System.out.println(list.get(0).getClass().getAnnotations());
        System.out.println(list.get(1).getClass().getAnnotations());

    }

    private static List<Class<?>> getAllClassesFrom(String packageName) {
        return new Reflections(packageName, new SubTypesScanner(false))
                .getAllTypes()
                .stream()
                .map(name -> {
                    try {
                        return Class.forName(name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
