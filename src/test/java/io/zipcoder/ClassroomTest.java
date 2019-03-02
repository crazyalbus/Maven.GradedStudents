package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
}
