package com.optional;

public class School implements Comparable<School>{

    String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public int compareTo(School other) {
        return this.schoolName.compareTo(other.schoolName);
    }

    @Override
    public String toString() {
        return schoolName;
    }
}
