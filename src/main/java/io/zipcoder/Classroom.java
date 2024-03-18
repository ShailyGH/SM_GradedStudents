package io.zipcoder;

import java.util.*;

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
        return this.students;
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
        studentList.toArray(students);
    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.addAll(Arrays.asList(students));

        for (Student student : students) {
            if (student.getLastName().equals(lastName) && student.getFirstName().equals(firstName))
            {
                studentList.remove(student);
                break;
            }
        }
        studentList.toArray(students);
    }

    public Student[] getStudentsByScore() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.addAll(Arrays.asList(students));

        for (int i = 0; i < studentList.size(); i++)
        {
            for (int j = i + 1; j < studentList.size() - 1; j++)
            {
                if (studentList.get(j).getAverageExamScore() > studentList.get(i).getAverageExamScore())
                {
                    Student tmp = studentList.get(j);
                    studentList.set(j, studentList.get(i));
                    studentList.set(i, tmp);
                }
            }
        }

        return studentList.toArray(new Student[0]);
    }

    public Map<Student, String> getGradeBook() {
       Map<Student, String> gradebook = new HashMap<>();

       for (Student s : students)
       {
           if(getPercentile(s) <= 0.1)
           {
               gradebook.put(s, "A");
           }
           else if (getPercentile(s) <= 0.29)
           {
               gradebook.put(s, "B");
           }
           else if (getPercentile(s) <= 0.50)
           {
               gradebook.put(s, "C");
           }
           else if (getPercentile(s) <= 0.89)
           {
               gradebook.put(s, "D");
           }
           else if (getPercentile(s) <= 1.0)
           {
               gradebook.put(s, "F");
           }
       }
       return gradebook;
    }

    public Double getPercentile(Student student)
    {
        //ArrayList<Student> studentList = new ArrayList<>(List.of(getStudentsByScore()));
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.addAll(Arrays.asList(students));

        int index = studentList.indexOf(student);
        if (index == -1)
        {
            return 1.00;
        }
        return (double) (index / studentList.size());

    }
}
