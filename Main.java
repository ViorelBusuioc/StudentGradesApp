package dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Student tim = new Student("Tim");
        Student [] students = {new Student("Zack"),new Student("Tim"),new Student("Ann")};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("result = " + tim.compareTo(new Student("TIM")));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students,gpaSorter.reversed());
        System.out.println(Arrays.toString(students));
    }
}
class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random randon = new Random();
    String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = randon.nextDouble(1.0,4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}
