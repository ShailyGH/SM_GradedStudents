package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest
{
    @Test
    public void getAverageExamScoreTest()
    {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudentTest()
    {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest()
    {
        //Given
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student1 = new Student("Mike", "Williams", examScores);
        Student student2 = new Student("Jennifer", "Williams", examScores);

        // When

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        Student[] preRemoval = classroom.getStudents();
        classroom.removeStudent("Mike", "Williams");
        Student[] postRemoval = classroom.getStudents();

        // Then
        String preRemovalAsString = Arrays.toString(preRemoval);
        String postRemovalAsString = Arrays.toString(postRemoval);

        System.out.println("===========================");
        System.out.println(preRemovalAsString);
        System.out.println("===========================");
        System.out.println(postRemovalAsString);

    }
    @Test
    public void getStudentsByScoreTest()
    {
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};

        // When
        Classroom classroom = new Classroom(students);

        // Then
        Assert.assertEquals(students, classroom.getStudentsByScore());
    }

    @Test
    public void getGradeBookTest() {
        //Given
        Double[] s1Scores = { 100.0};
        Double[] s2Scores = { 225.0};
        Double[] s3Scores = { 50.0};
        Double[] s4Scores = { 120.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] students = {s1, s2, s3, s4};
        Classroom classroom = new Classroom(students);

        // When
        Map<Student, String> myMap = classroom.getGradeBook();

        // Then
        Assert.assertEquals("A", myMap.get(students[0]));
        Assert.assertEquals("A", myMap.get(students[1]));
        Assert.assertEquals("A", myMap.get(students[2]));
        Assert.assertEquals("A", myMap.get(students[3]));
    }
}
