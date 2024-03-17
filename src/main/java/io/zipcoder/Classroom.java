package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this(new Student[30]);
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double totalAverageScore = 0.0;
        for (Student student : students) {
            totalAverageScore += student.getAverageExamScore();
        }
        return totalAverageScore / students.length;
    }

    public void addStudent(Student student) {
        ArrayList<Student> studentList = new ArrayList<>();

        for (Student stu : students) {
            if (!Objects.isNull(stu)) {
                studentList.add(stu);
            }
        }
        if (studentList.size() < 30) {
            studentList.add(student);
        }
        //students = (Student[])studentList.toArray();
        Student[] studentsAsArray = new Student[studentList.size()];
        studentsAsArray = studentList.toArray(studentsAsArray);
        this.students = studentsAsArray;
    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> studentList = new ArrayList<Student>();

        for (Student student : students) {
            if (student.getLastName().equals(lastName) && student.getFirstName().equals(firstName)) {
                studentList.remove(student);
            }
        }
        students = (Student[]) studentList.toArray();
    }

    public Student[] getStudentsByScore() {
        return (Student[]) Arrays.stream(students).sorted().toArray();
    }

    public void getGradeBook() {
//        ArrayList<Student> studentList = new ArrayList<Student>();
//        Double maxNumber = studentList.stream().max(x,y)->
//        {
//            return x.getAverageExamScore(). compareTo(y.getAverageExamScore());})).get().getAverageExamScore();
//        }
    }
}
