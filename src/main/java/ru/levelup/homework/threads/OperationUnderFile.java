package ru.levelup.homework.threads;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class OperationUnderFile {

    ArrayList<Integer> list;


    public Integer calculationResult(ArrayList<Integer> list){
        Integer result=0;
        if (list.get(0) == 1){
            for(int i=1; i< list.size(); i++){
                result = result + list.get(i);
            }
        }
        else if(list.get(0)==2){
            result=1;
            for(int i=1; i< list.size(); i++){
                result = result * list.get(i);
            }
        }
        else if(list.get(0)==3){
            for(int i=1; i< list.size(); i++){
                result = result + list.get(i)*list.get(i);
            }
        }
        return result;

    }


}
