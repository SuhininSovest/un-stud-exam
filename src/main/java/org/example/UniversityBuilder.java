package org.example;

public interface UniversityBuilder {
    UniversityBuilder setId(String id);
    UniversityBuilder setFullName(String fullName);
    UniversityBuilder setShortName(String shortName);
    UniversityBuilder setYearOfFoundation(int yearOfFoundation);
    UniversityBuilder setMainProfile(StudyProfile mainProfile);
    University build();
}
