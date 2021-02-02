package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private final int id;
    protected int age;
    protected String name;
    Size size;

    private final List<Human> children = new ArrayList<>();

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    private BloodGroup bloodGroup;

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }



    public Human(String name, int age) {

        this.age = age;
        this.name = name;
        this.id = nextId;
        nextId++;
    }

    public String getPosition() {
        return "Человек";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }


    public void live() {
    }

    public int getId() {
        return id;
    }

    public class Size {
        public int height;
        public int weight;


        public Size(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
}