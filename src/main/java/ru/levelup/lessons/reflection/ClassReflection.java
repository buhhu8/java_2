package ru.levelup.lessons.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Watch watch = new Watch();

        Class<?> watchClass =watch.getClass();
        //2 var
        Class<?> watchClassLiteral = Watch.class;

        System.out.println(watchClass==watchClassLiteral); //always ture


        String className =watchClass.getName();
        System.out.println("Class name "+ className);

        Field[] fields = watchClass.getDeclaredFields();
        for(Field f : fields){
            Class<?> fieldTypeClass = f.getType();

            boolean isPrimitive = fieldTypeClass.isPrimitive();
            System.out.println(f.getName()+ " " + fieldTypeClass.getName() + ", is primitive: " + isPrimitive);
        }

        Field brandField =  watchClass.getDeclaredField("brand");
        System.out.println("Field value before: " + watch.getBrand());

        brandField.setAccessible(true);
        brandField.set(watch, "Samsung");

        System.out.println("Field value after:" + watch.getBrand());

        Method printWatchMethod = watchClass.getDeclaredMethod("printWatch");
        printWatchMethod.setAccessible(true);
        printWatchMethod.invoke(watch);

        Constructor<?> allArgs = watchClass.getDeclaredConstructor(String.class, String.class, double.class, int[].class);
        Watch createdWatch = (Watch) allArgs.newInstance("Watch #4", "Swatch", 28.5d , null );
        System.out.println(createdWatch.getName() + " " + createdWatch.getBrand() + createdWatch.getDiagonal());


    }
}
