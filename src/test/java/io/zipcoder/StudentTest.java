package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTest {

    @Test
    public void getExamScoresTest() {
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, Arrays.asList(examScores));
        String expected = "Exam Scores:\n" +
                "  Exam 1 -> 100\n" +
                "  Exam 2 -> 95\n" +
                "  Exam 3 -> 123\n" +
                "  Exam 4 -> 96\n";

        // When
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test

    public void addExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, scores);
        String expected = "Exam Scores:\n" +
                "  Exam 1 -> 100\n";

        // When
        student.addExamScore(100.0);

        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, scores);
        String expected = "Exam Scores:\n" +
                "  Exam 1 -> 150\n";

        // When
        student.setExamScore(1, 150.0);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, scores);
        double expected = 125;

        // When
        double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, .001);
    }

    @Test
    public void toStringOverrideTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, scores);
        String expected = "Student Name: Leon Hunter\n" +
                "Average Score: 125\n" +
                "Exam Scores:\n" +
                "  Exam 1 -> 100\n" +
                "  Exam 2 -> 150\n" +
                "  Exam 3 -> 250\n" +
                "  Exam 4 -> 0\n";

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);

    }
}