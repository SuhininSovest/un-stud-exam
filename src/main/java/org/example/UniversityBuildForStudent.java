package org.example;

public class UniversityBuildForStudent implements UniversityBuilder{
    University university = new University();

    @Override
    public UniversityBuilder setId(String id) {
        university.id = id;
        return this;
    }

    @Override
    public UniversityBuilder setFullName(String fullName) {
        university.fullName = fullName;
        return this;
    }

    @Override
    public UniversityBuilder setShortName(String shortName) {
        university.shortName = shortName;
        return this;
    }

    @Override
    public UniversityBuilder setYearOfFoundation(int yearOfFoundation) {
        university.yearOfFoundation = yearOfFoundation;
        return this;
    }

    @Override
    public UniversityBuilder setMainProfile(StudyProfile mainProfile) {
        university.mainProfile = mainProfile;
        return this;
    }

    @Override
    public University build() {
        return university;
    }
}
