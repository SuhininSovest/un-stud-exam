package org.example;

public interface StudentBuilder {
    StudentBuilder setFullName(String fullName);
    StudentBuilder setUniversityId(String universityId);
    StudentBuilder setCurrentCourseNumber(int currentCourseNumber);
    StudentBuilder setAvgExamScore(float avgExamScore);
    Student build();
}
