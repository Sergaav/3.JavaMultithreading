package com.javarush.task.task26.task2601;

import java.util.*;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Integer[] array = new Integer[]{13, 8, 15, 5, 17,12};
//        System.out.println(Arrays.toString(sort(array)));

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int mediana;
        if (array.length % 2 == 0) {
            mediana = (array[array.length / 2] + array[array.length / 2 -1]) / 2;
        } else mediana =  array[array.length / 2];

        System.out.println(mediana);
        Arrays.sort(array, Comparator.comparingInt(n -> Math.abs(mediana - n)));

        return array;
    }
}
