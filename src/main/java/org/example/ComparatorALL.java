package org.example;

import org.example.EnumComparator.EnumStudentCompartor;
import org.example.EnumComparator.EnumUniversityCompartor;
import org.example.comparator.*;

public class ComparatorALL {
    public static UniversityComparator getUniversityComparator(EnumUniversityCompartor enumUniversityCompartor) {
        switch(enumUniversityCompartor){
            case UNIVERSITY_ID:
                return new UniversityIdComporator();
            case UNIVERSITY_FN:
                return new UniversityFullNameComparator();
            case UNIVERSITY_SH:
                return new UniversityShortNameComparator();
            case UNIVERSITY_YEARS:
                return new UnivercityYearofFoundationComparator();
            case UNIVERSITY_MAINPROFILE:
                return new UnivercityMainProfileComparator();
            default:
                return new UniversityIdComporator();
        }
    }

    public static StudentComparator getStudentComparator(EnumStudentCompartor enumStudentCompartor) {
        switch (enumStudentCompartor) {
            case STUD_FN_COMPARATOR:
                return new StudentFullNameComparator();
            case STUD_UNIVID:
                return new StudentUniversityIdComparator();
            case STUD_CURRENTCORS:
                return new StudentCurrentCourseNumberComparator();
            case STUD_AVGEXAM:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }
}
