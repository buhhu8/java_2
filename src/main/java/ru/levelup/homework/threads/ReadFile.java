package ru.levelup.homework.threads;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

@RequiredArgsConstructor
public class ReadFile {

    BufferedReader reader;

    @SneakyThrows
    public ArrayList<Integer> listOfNumbers(BufferedReader reader){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(reader.readLine()));
        String ch = reader.readLine();
        String[]arr = null;
        while(ch!=null){
            arr = ch.split(" ");
            ch=reader.readLine();

        }
        for(String str : arr){
            list.add(Integer.parseInt(str));
        }
        reader.close();
        return list;
    }

}
