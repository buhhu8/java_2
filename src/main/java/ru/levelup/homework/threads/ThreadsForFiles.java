package ru.levelup.homework.threads;

import lombok.SneakyThrows;
import ru.levelup.lessons.threads.Threads;

import java.io.*;
import java.util.ArrayList;


public class ThreadsForFiles extends Thread {

         String fileName;
         ReadFile readFile = new ReadFile();
         BufferedReader reader;
         BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\out.txt",true));

        @SneakyThrows
        public ThreadsForFiles(String fileName) throws IOException {

         this.fileName = fileName;

        }

        @SneakyThrows
        @Override
        public void run() {
            reader = new BufferedReader(new FileReader(fileName));
            OperationUnderFile operationUnderFile = new OperationUnderFile();
            ArrayList<Integer> list1 =  readFile.listOfNumbers(reader);
       //     System.out.println(Thread.currentThread() + "read");
            synchronizedWriter(operationUnderFile, list1);
            reader.close();
        }

     @SneakyThrows
    public synchronized void synchronizedWriter(OperationUnderFile operationUnderFile, ArrayList<Integer> list1) {
     //    System.out.println(Thread.currentThread() + "write");
        writer.write (String.valueOf(operationUnderFile.calculationResult(list1)) + " ");
        writer.close();

    }


}
