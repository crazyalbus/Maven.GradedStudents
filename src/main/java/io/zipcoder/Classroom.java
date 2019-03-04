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

    public Map<String, Student> getGradeBook() {

    }
//    The class Classroom should define a method getGradeBook() which returns a mapping of Student objects to a respective letter grade determined by creating a grading curve such that
//    An A is awarded to students whose class average is in the upper 10th percentile.
//    A B is awarded to students whose class average falls between the 11th and 29th percentile.
//    A C is awarded to students whose class average falls between the 30th and 50th percentile.
//    A D is awarded to students whose class average falls between the 51st and 89th percentile.
//    An F is awarded to students whose class average is in the lower 11th percentile.
//


}

