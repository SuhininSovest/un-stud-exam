package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


import static org.example.EnumComparator.EnumStudentCompartor.STUD_FN_COMPARATOR;
import static org.example.EnumComparator.EnumUniversityCompartor.UNIVERSITY_YEARS;


public class Main {
    public static void main(String[] args) throws IOException {

        List<University> universities =
                XSSFReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorALL.getUniversityComparator(UNIVERSITY_YEARS);

        Collections.sort(universities, universityComparator);
        universities.stream().forEach(System.out::println);

        List<Student> students =
                XSSFReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorALL.getStudentComparator(STUD_FN_COMPARATOR);

        Collections.sort(students, studentComparator);
        students.stream().forEach(System.out::println);


    }

}
