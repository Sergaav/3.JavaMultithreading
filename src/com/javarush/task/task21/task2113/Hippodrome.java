package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }

    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                move();
                Thread.sleep(200);
                print();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int index = 0;
        double maxDistance=0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > maxDistance) {
                maxDistance = horses.get(i).getDistance();
                index=i;
            }
        }
        return horses.get(index);
    }

    public void printWinner() {
        System.out.println("Winner is "+ getWinner().getName()+"!");

    }


    public static void main(String[] args) {

        Hippodrome hippodrome = new Hippodrome(new ArrayList<>());
        hippodrome.horses.add(new Horse("Veterok", 3, 0));
        hippodrome.horses.add(new Horse("Snezhok", 3, 0));
        hippodrome.horses.add(new Horse("Urahan", 3, 0));
        game = hippodrome;
        game.run();
        game.printWinner();

    }
}
