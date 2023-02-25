package org.example;

public class Main {
    public static void main(String[] args) {
        Student student = new StudentBuilderToUniversity().setFullName("Petr").setUniversityId("1314")
                .setCurrentCourseNumber(12).setAvgExamScore(12.4f).build();
        University university = new UniversityBuildForStudent().setId("535g").setFullName("Уральский ун.......").setShortName("УРФУ")
                .setYearOfFoundation(5).setMainProfile(StudyProfile.MEDICINE).build();
        System.out.println(student);
        System.out.println(university);
    }
}
