package io.zipcoder;

import org.junit.Test;

import java.util.Arrays;

public class StudentTest
{
    @Test
    public void getExamScoresTest()
    {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void addExamScoreTest()
    {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void setExamScoreTest()
    {
        // : Given
        Double[] examScores1 = { 102.0 };
        Student student1 = new Student("Leon", "Hunter", examScores1);

        // When
        student1.setExamScore(0, 150.0);

        String output = student1.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void getAverageExamScoreTest()
    {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double output = student.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void toStringTest()
    {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }
}