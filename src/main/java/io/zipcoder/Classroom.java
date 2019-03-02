package io.zipcoder;

import java.lang.reflect.Array;

public class Classroom {

    Student[] students;
    int maxNumberOfStudents;

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }


    public Student[] getStudents() {
        return students;
    }


    public double getAverageExamScore() {

        double sumAverageScores = 0;

        for (Student student:students
             ) {
            sumAverageScores += student.getAverageExamScore();
        }
        
        return sumAverageScores / students.length;
    }


    public void add(Student student) {

        for (int i = 0; i < students.length; i++) {
            if (Array.get(students, i) != null) {
                Array.set(students, i, student);
            }
        }
    }
        

}
