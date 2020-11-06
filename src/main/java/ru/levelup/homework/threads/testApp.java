package ru.levelup.homework.threads;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class testApp {

    @SneakyThrows
    public static void main(String[] args) {

        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\out.txt"));
        ReadFile readFile = new ReadFile();
        File dir = new File("E:\\"); //path указывает на директорию
        List<String> lst = new ArrayList<>();
        for ( File file : dir.listFiles() ){
            if ( file.isFile() )
                lst.add(file.toString());
        }
        Pattern pattern = Pattern.compile("^in_[\\d]{1,}.txt$");  //файлы начинающиеся на in_ и заканчивающиеся на .txt
        Matcher matcher;
        for(String list: lst){
            matcher = pattern.matcher(list.replace("E:\\",""));
            if(matcher.find()){
                new ThreadsForFiles(list).start();
            }
        }


    }

}
