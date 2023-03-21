package org.example.Utill;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Student;
import org.example.model.University;

import java.util.Collections;
import java.util.List;

//Класс для сериализаци десериализации через  Google GSON
public class JsonUtil {
    private JsonUtil() {}

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static String studentListToJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static String universityListToJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    public static List<Student> jsonToStudentList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static List<University> jsonToUniversityList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }
}
