package io.zipcoder;

import org.junit.After;

import java.lang.reflect.Array;
import java.util.*;

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

        ArrayList<Student> workingArray = new ArrayList<>(Arrays.asList(students));

        for (Student s : workingArray
             ) {
            if(s == null) {
                workingArray.set(workingArray.indexOf(s), student);
                break;
            }
        }
        workingArray.toArray(students);
    }
        
    public void removeStudent(String firstName, String lastName) {

        ArrayList<Student> workingArray = new ArrayList<>(Arrays.asList(students));

        for (Student s : workingArray)
            { if((firstName.equals(s.getFirstName())) && (lastName.equals(s.getLastName())))
            {
                workingArray.remove(workingArray.indexOf(s));
            }
        }

        workingArray.toArray(students);
    }


    public Student[] getStudentsByScore() {
        Comparator<Student> compareLastName = new LastNameComparator();
        Comparator<Student> compareGrades = new GradeComparator().reversed();
        Arrays.sort(students, compareLastName);
        Arrays.sort(students,compareGrades);

        return students;

    }

    public Map<String, String> getGradeBook() {

        Student[] gradesForReport = getStudentsByScore();

        Map<String, String> gradeBook = new HashMap<>();

        for (Student s : gradesForReport) {
            if      (s.getAverageExamScore() >= 90) {
                        gradeBook.put(s.getLastName() + ", " + s.getFirstName(), "A"); continue;}
            else if (s.getAverageExamScore() >= 70) {
                        gradeBook.put(s.getLastName() + ", " + s.getFirstName(), "B"); continue;}
            else if (s.getAverageExamScore() >= 50) {
                        gradeBook.put(s.getLastName() + ", " + s.getFirstName(), "C"); continue;}
            else if (s.getAverageExamScore() >= 10) {
                        gradeBook.put(s.getLastName() + ", " + s.getFirstName(), "D"); continue;}
            else    { gradeBook.put(s.getLastName() + ", " + s.getFirstName(), "F"); continue;}
        }
        return gradeBook;
    }


}

