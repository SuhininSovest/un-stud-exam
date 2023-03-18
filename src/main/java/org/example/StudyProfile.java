package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"), INFORMATICS("Информатика"), PHYSICS("Физика"), LINGUISTICS("Лингвичтика"), MATHEMATICS("Математика");
    private String translation;
    StudyProfile(String translation){
        this.translation=translation;
    }
    public String GetTranslation() {
        return translation;
    }
}