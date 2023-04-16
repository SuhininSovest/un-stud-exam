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

    public static String allListStUnToJson(List<?> object) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }
}
