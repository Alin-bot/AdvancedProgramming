package com.optional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return studentName;
    }
}
