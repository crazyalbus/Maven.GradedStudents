package io.zipcoder;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {


    public int compare(Student student1, Student student2) {
        return Double.compare(student1.getAverageExamScore(), student2.getAverageExamScore());
    }
}
