package io.zipcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private List<Double> examScores;

    public Student(String firstName, String lastName, List<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        String examScoreReport = "Exam Scores:\n";

        for (int i = 0; i < examScores.size(); i++) {
            examScoreReport += String.format("  Exam %d -> %.0f\n", i+1, examScores.get(i));
        }

        return examScoreReport;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public void addExamScore(Double newScore){
        examScores.add(newScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {

        double sum = 0;

        for (double score : examScores
             ) {
            sum += score;
        }

        return sum / getNumberOfExamsTaken();
    }

    public String toString() {
        String studentReport = String.format("" +
                "Student Name: %s %s\n" +
                "Average Score: %.0f\n",
                getFirstName(), getLastName(), getAverageExamScore()) +
                getExamScores();

        return studentReport;
    }


}
