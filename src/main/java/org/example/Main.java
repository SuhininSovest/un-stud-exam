package org.example;

import org.example.Utill.ComparatorALL;
import org.example.Utill.StatisticsUnSt;
import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.oi.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.LogManager;


import static org.example.EnumComparator.EnumStudentCompartor.STUD_FN_COMPARATOR;
import static org.example.EnumComparator.EnumUniversityCompartor.UNIVERSITY_YEARS;


public class Main {
    // Инициализация логера
    private static final Log log = LogFactory.getLog(Main.class.getName());
    public static void main(String[] args) throws IOException {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        log.info("Start Main");
        log.debug("Main");
        List<University> universities =
                XSSFReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorALL.getUniversityComparator(UNIVERSITY_YEARS);
        Collections.sort(universities, universityComparator);

        List<Student> students =
                XSSFReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorALL.getStudentComparator(STUD_FN_COMPARATOR);
        Collections.sort(students, studentComparator);

        //Анализ статистики
        List<Statistics> statisticsList = StatisticsUnSt.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        AllListStUn allListStUn = new AllListStUn()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList);

        XMLWriter.generateXML(allListStUn);
        JsonWriter.writeJson(allListStUn);
        log.info("Finish Main");
    }
}
