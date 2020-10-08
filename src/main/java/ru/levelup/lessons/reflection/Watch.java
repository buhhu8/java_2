package ru.levelup.lessons.reflection;

import lombok.*;
import ru.levelup.lessons.reflection.annotation.RandomInt;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Watch {

    private String name;
    private String brand;
    private double diagonal;
    private int[] numbers;

    @RandomInt(max = 300, min =50)
    private int weight;
    @RandomInt(max = 40)
    private int length;

    private  void printWatch() {
        System.out.println("Name " + name + " brand " + brand );
    }
}
