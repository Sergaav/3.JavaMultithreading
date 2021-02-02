package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {


    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);

    }

    public static String readString(){
        String temp = null;
        boolean flag=true;
        while (flag){
        try {
            temp = bufferedReader.readLine();
            flag=false;
        } catch (IOException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
        }}
        return temp;
    }

    public static int readInt(){
        int temp=0;
        boolean flag=true;
        while (flag) {
            try {
                temp = Integer.parseInt(readString());
                flag=false;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return temp;
    }
}
