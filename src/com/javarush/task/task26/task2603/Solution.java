package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T>{

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg ) {
            this.comparators = vararg ;
        }


        @Override
        public int compare(T o, T t1) {
            int result=0;
            for (int i=0;i<comparators.length;i++){
                if (result == 0){
                result= comparators[i].compare(o,t1);
            }}
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
