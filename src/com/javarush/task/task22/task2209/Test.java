package com.javarush.task.task22.task2209;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        String[] mas = {"1", "2", "3", "4", "5"};
        search(mas, mas.length);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());

    }

    public static void search(String[] m, int n) {

        if (n == 0) {
            return;
        }
        for (int i = m.length - 1; i > 0; i--) {
            String temp = m[i];
            m[i] = m[i - 1];
            m[i - 1] = temp;
            list.add(Arrays.toString(m));


            search(m, n - 1);

        }
//        for (int j=m.length-1;j>)
//



    }


}

