package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/


import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        int telLength = telNumber.replaceAll("\\D", "").length();
        String regEx1 = "\\+\\d((\\d*\\(\\d{3}\\))?\\d*-?\\d+-?\\d*)\\d";
        String regEx2 = "((\\d*\\(\\d{3}\\))?\\d*-?\\d+-?\\d*)\\d";
        boolean result = false;
        if (telNumber.matches("\\+.*") && telLength == 12) {
            result = telNumber.matches(regEx1);
        }
        if (telNumber.matches("\\.*|\\(.*") && telLength == 10) {
            result = telNumber.matches(regEx2);
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("050123-4567"));

    }
}
