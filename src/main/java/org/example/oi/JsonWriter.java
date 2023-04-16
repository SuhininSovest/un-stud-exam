package org.example.oi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.Utill.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonWriter {
    static Date date = new Date();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy") ;
    static String curDate = dateFormat.format(date);
    private static final Log log = LogFactory.getLog(XMLWriter.class.getName());

    private JsonWriter() {
    }
    public static void writeJson(AllListStUn allListStUn) {
        log.info("start generateXmlReq. (Creat file xml)");
        log.debug("generateXmlReq work");
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            log.info("Directory created successfully");
        } catch (IOException e) {
            log.debug("Directory already created");
        }
        writeStudents(allListStUn);
        writeUniversities(allListStUn);
        writeStatisticsList(allListStUn);
    }
        private static void writeStudents(AllListStUn allListStUn) {
            String studentsJson = JsonUtil.allListStUnToJson(allListStUn.getStudentList());
            try {
                FileOutputStream outputStream =
                        new FileOutputStream("jsonReqs\\jsonStudents_" + curDate + ".json");
                outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                log.debug("create json Students faild", e);
            }
        }


        private static void writeUniversities(AllListStUn allListStUn) {
            String universitiesJson = JsonUtil.allListStUnToJson(allListStUn.getUniversityList());
            try {
                FileOutputStream outputStream =
                        new FileOutputStream("jsonReqs\\jsonUniversities_" + curDate + ".json");
                outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                log.debug("create json Universities faild", e);
            }
        }

        private static void writeStatisticsList(AllListStUn allListStUn) {
            String studentsJson = JsonUtil.allListStUnToJson(allListStUn.getStatisticsList());
            try {
                FileOutputStream outputStream =
                        new FileOutputStream("jsonReqs\\jsonStatistics_" + curDate + ".json");
                outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                log.debug("create json Statistics faild", e);
            }
    }
}

