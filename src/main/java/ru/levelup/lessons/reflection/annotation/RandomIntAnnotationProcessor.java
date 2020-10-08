package ru.levelup.lessons.reflection.annotation;



import lombok.SneakyThrows;
import ru.levelup.lessons.reflection.Watch;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationProcessor {

    @SneakyThrows
    public Watch initializeWatch(){
        // Создать объект класса Watch
        // найти поля у которых есть анотация @randomint
        // Сгенерировать значения
        // Засетить значение в поле

        Class<?> watchClass = Watch.class;

        Constructor<?> emptyConstructor = watchClass.getDeclaredConstructor();
        Watch watchObj = (Watch) emptyConstructor.newInstance();

        Field[] fields = watchClass.getDeclaredFields();
        for(Field f : fields){
            RandomInt annotation = f.getAnnotation(RandomInt.class);
            if(annotation != null) {
                int minValue = annotation.min();
                int maxValue = annotation.max();

                Random r = new Random();
                int randomValue = r.nextInt(maxValue + minValue);

                f.setAccessible(true);
                f.set(watchObj, randomValue);
            }
        }
        return watchObj;

    }
}
