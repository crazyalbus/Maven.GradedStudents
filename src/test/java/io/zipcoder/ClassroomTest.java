package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {

    @Test
    public void getAverageExamScoreTest() {

        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        ArrayList<Double> s1s = new ArrayList<>(Arrays.asList(s1Scores));

        Double[] s2Scores = { 225.0, 25.0 };
        ArrayList<Double> s2s = new ArrayList<>(Arrays.asList(s2Scores));

        Student s1 = new Student("student", "one", s1s);
        Student s2 = new Student("student", "two", s2s);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);
        double expected = 125.0;

        // When
        double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, .001);
    }

    @Test
    public void addStudentTest() {

        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0};
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student("Leon", "Hunter", scores);

        // When
        classroom.add(student);
        int expected = 1;
        Student[] studentList = classroom.getStudents();
        int actual = studentList.length;

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeStudentTest() {
        // : Given
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student("Leon", "Hunter", scores);
        Student student2 = new Student("Bob", "Barker", scores);

        // When
        classroom.add(student);
        classroom.add(student2);
        classroom.removeStudent("Leon", "Hunter");
        int expected = 1;
        Student[] studentList = classroom.getStudents();
        int actual = 0;
        for (Student s : studentList
        ) {
            if (s != null) {
                actual++;

            }
        // Then
        Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void getStudentsByScoreTest(){
// : Given
        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] s1s = {100.0, 150.0, 250.0, 0.0};
        Double[] s2s = {100.0, 150.0, 250.0, 0.0};
        Double[] s3s = {90.0, 150.0, 210.0, 0.0};
        Double[] s4s = {100.0, 110.0, 190.0, 0.0};
        ArrayList<Double> s1sal = new ArrayList<>(Arrays.asList(s1s));
        ArrayList<Double> s2sal = new ArrayList<>(Arrays.asList(s2s));
        ArrayList<Double> s3sal = new ArrayList<>(Arrays.asList(s3s));
        ArrayList<Double> s4sal = new ArrayList<>(Arrays.asList(s4s));
        Student student1 = new Student("Leon", "Hunter", s1sal);
        Student student2 = new Student("Bob", "Barker", s2sal);
        Student student3 = new Student("Betty", "Boop", s3sal);
        Student student4 = new Student("Gerald", "Ford", s4sal);
        String expected = "Bob Barker - 125\nLeon Hunter - 125\nBetty Boop - 113\nGerald Ford - 100\n";

        // When
        classroom.add(student1);
        classroom.add(student2);
        classroom.add(student3);
        classroom.add(student4);

        Student[] gradeReport = classroom.getStudentsByScore();

        String actual = "";
        for (Student s : gradeReport
             ) {
            actual = actual + String.format("%s %s - %.0f\n", s.getFirstName(), s.getLastName(), s.getAverageExamScore());
        }
        Assert.assertEquals(expected, actual);

        }

    @Test
    public void getGradeBook() {
        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] s1s = {100.0, 90.0, 87.0, 92.0};
        Double[] s2s = {100.0, 90.0, 87.0, 92.0};
        Double[] s3s = {90.0, 100.0, 79.0, 88.0};
        Double[] s4s = {69.0, 60.0, 75.0, 70.0};
        ArrayList<Double> s1sal = new ArrayList<>(Arrays.asList(s1s));
        ArrayList<Double> s2sal = new ArrayList<>(Arrays.asList(s2s));
        ArrayList<Double> s3sal = new ArrayList<>(Arrays.asList(s3s));
        ArrayList<Double> s4sal = new ArrayList<>(Arrays.asList(s4s));
        Student student1 = new Student("Leon", "Hunter", s1sal);
        Student student2 = new Student("Bob", "Barker", s2sal);
        Student student3 = new Student("Betty", "Boop", s3sal);
        Student student4 = new Student("Gerald", "Ford", s4sal);

        // When
        classroom.add(student1);
        classroom.add(student2);
        classroom.add(student3);
        classroom.add(student4);

        Set<Map.Entry<String, String>> gradeBook = classroom.getGradeBook().entrySet();

        String actual = "";



        for (Map.Entry<String, String> entry : gradeBook
             ) {
            actual = actual + String.format("%S: %S\n",entry.getValue(), entry.getKey());
        }
        System.out.println(actual);

    }
}
