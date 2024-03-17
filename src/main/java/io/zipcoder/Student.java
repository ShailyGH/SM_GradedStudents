package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student
{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
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
        int examCounter = 0;
        StringBuilder output = new StringBuilder();

        for (Double score : examScores)
        {
            examCounter ++;
            output.append("\t").append("Exam ").append(examCounter).append(" -> ").append(score).append("\n");
        }
        return output.toString();
    }

    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public void addExamScore(double examScore)
    {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore)
    {
        examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore()
    {
        Double totalExamScore = 0.0;
        int numberOfExamTaken = 0;

        numberOfExamTaken = getNumberOfExamsTaken();
        for (Double score : examScores) {
            totalExamScore += score;
        }
        return totalExamScore / numberOfExamTaken;
    }
    @Override
    public String toString()
    {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", examScores=" + examScores +
                '}';
    }
}
