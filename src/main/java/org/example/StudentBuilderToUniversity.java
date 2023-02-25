package org.example;

public class StudentBuilderToUniversity implements StudentBuilder{
    Student student = new Student();

    @Override
    public StudentBuilder setFullName(String fullName) {
        student.fullName = fullName;
        return this;
    }
    @Override
    public StudentBuilder setUniversityId(String universityId) {
        student.universityId = universityId;
        return this;
    }
    @Override
    public StudentBuilder setCurrentCourseNumber(int currentCourseNumber) {
        student.currentCourseNumber = currentCourseNumber;
        return this;
    }
    @Override
    public StudentBuilder setAvgExamScore(float avgExamScore) {
        student.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public Student build() {
        return student;
    }
}
