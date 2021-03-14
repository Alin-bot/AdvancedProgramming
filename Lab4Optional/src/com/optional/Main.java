package com.optional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        List<Student> studentList = new ArrayList<>(); // list of students
        for (Student s : students) {
            studentList.add(s);
        }
        Collections.sort(studentList, Comparator.comparing(Student::getStudentName)); // sorting the list

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        TreeSet<School> schoolTreeSet = new TreeSet<>(); // tree set of schools
        for (School s : schools) {
            schoolTreeSet.add(s);
        }


        List<School> schoolList = new ArrayList<>(); // list of schools
        for (School s : schools) {
            schoolList.add(s);
        }

        Map<Student, List<School>> stdPrefMap = new HashMap<>(); // creating the maps for the preferences of the students
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        Map<School, List<Student>> schPrefMap = new LinkedHashMap<>(); // creating the maps for the preferences of the schools
        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        System.out.println(stdPrefMap.toString());
        System.out.println(schPrefMap.toString());
        System.out.println();

        Problem p = new Problem(stdPrefMap, schPrefMap);

        List<School> target = Arrays.asList(schools[0], schools[2]);
        List<Student> result = studentList.stream()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .collect(Collectors.toList());
        System.out.print("The students: ");
        for (Student s : result) {
            System.out.print(s + " ");
        }
        System.out.println("find acceptable the next schools: " + target);

        System.out.print("The schools: ");
        schoolList.stream()
                .filter(sch -> schPrefMap.get(sch).contains(students[3]))
                .forEach(System.out::print);
        System.out.print(" have the student: " + students[3] + " as their preference");
        System.out.println();

    }
}
