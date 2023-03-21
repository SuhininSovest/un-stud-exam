package org.example.model;

public enum StudyProfile {
    MEDICINE("Медицина"), INFORMATICS("Информатика"), PHYSICS("Физика"), LINGUISTICS("Лингвичтика"), MATHEMATICS("Математика");
    private String translation;
    private StudyProfile(String translation){
        this.translation=translation;
    }
    public String GetTranslation() {
        return translation;
    }

}