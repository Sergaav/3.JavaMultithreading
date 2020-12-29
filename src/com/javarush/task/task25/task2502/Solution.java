package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            String [] mas = loadWheelNamesFromDB();
            wheels=new ArrayList<>();
            if (mas.length == 4) {
                for (int i = 0; i < mas.length; i++) {
                    if (mas[i].equals("FRONT_LEFT")) {
                        wheels.add(Wheel.FRONT_LEFT);
                    } else if (mas[i].equals("FRONT_RIGHT")) {
                        wheels.add(Wheel.FRONT_RIGHT);
                    } else if (mas[i].equals("BACK_LEFT")) {
                        wheels.add(Wheel.BACK_LEFT);
                    } else if (mas[i].equals("BACK_RIGHT")) {
                        wheels.add(Wheel.BACK_RIGHT);
                    } else throw new UnsupportedOperationException();
                }
            }else throw new UnsupportedOperationException();
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
