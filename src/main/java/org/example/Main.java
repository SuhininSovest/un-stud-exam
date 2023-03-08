package org.example;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        //Запускаем чтение Excel
        GetsXSSF.studentWriteExcel();
        GetsXSSF.universityWriteExcel();
        //Проверка Collection
        System.out.println(GetsXSSF.sudentToCollection.toString());
        System.out.println(GetsXSSF.universityToCollection.toString());
    }
}
