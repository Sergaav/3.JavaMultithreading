package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double avarageGrade) {
        Student temp = null;
        for (Student student : students) {
            if (student.getAverageGrade() == avarageGrade) {
                temp = student;
                break;
            }

        }
        return temp;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAveregeGrade = 0.0;
        Student studentMaxAvGr = null;
        for (Student student : students) {
            if (student.getAverageGrade() >= maxAveregeGrade) {
                studentMaxAvGr = student;
                maxAveregeGrade = student.getAverageGrade();
            }
        }
        return studentMaxAvGr;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAveregeGrade = 5.0;
        Student studentMaxAvGr = null;
        for (Student student : students) {
            if (student.getAverageGrade() <= minAveregeGrade) {
                studentMaxAvGr = student;
                minAveregeGrade = student.getAverageGrade();
            }
        }
        return studentMaxAvGr;
    }

    public void expel(Student student) {
        students.remove(student);
    }

}