package com.optional;

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
