package org.example.model;


import com.google.gson.annotations.SerializedName;

public class Student{
    public Student() {}
    @SerializedName("studentFN")
    String fullName;
    @SerializedName("StudUniverId")
    String universityId;
    @SerializedName("StudCurrentCourseNumber")
    int currentCourseNumber;
    @SerializedName("StudAVG")
    float avgExamScore;

    public Student(String universityId, String fullName,  int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Студент : " + "Реестовый номер института " + getUniversityId() + ", ФИО: " + getFullName() +
                ", Номер курса: " + getCurrentCourseNumber() + ", Средний балл за курс: " + getAvgExamScore();
    }

}

