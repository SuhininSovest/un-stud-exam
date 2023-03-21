package org.example;

import org.example.Utill.ComparatorALL;
import org.example.Utill.JsonUtil;
import org.example.Utill.StatisticsUnSt;
import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.oi.XSSFReader;
import org.example.oi.XlsWriter;

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

        String universitiesJson = JsonUtil.universityListToJson(universities);
        // проверка json
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        // Сравнение коллекций на кол-во элементов
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            // Создание json из отдельного объекта класса University
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверяем отдельный объект
            System.out.println(universityFromJson);
        });


        List<Student> students =
                XSSFReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorALL.getStudentComparator(STUD_FN_COMPARATOR);
        Collections.sort(students, studentComparator);
        students.stream().forEach(System.out::println);

        String studentsJson = JsonUtil.studentListToJson(students);
        // проверка json
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        // Сравнение коллекций на кол-во элементов
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            // Создание json из отдельного объекта класса Student
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверяем отдельный объект
            System.out.println(studentFromJson);
        });
        //Анализ статистики
        List<Statistics> statisticsList = StatisticsUnSt.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");
    }
}
