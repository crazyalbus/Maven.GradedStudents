package io.zipcoder;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Student> {


    public int compare(Student student1, Student student2) {
        return student1.getLastName().compareTo(student2.getLastName());
    }
}
