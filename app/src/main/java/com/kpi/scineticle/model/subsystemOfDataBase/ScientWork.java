package com.kpi.scineticle.model.subsystemOfDataBase;

public abstract class ScientWork {

    public static final String ARTICLE = "Стаття";
    public static final String BIBLIOGRAPHIC_POINTER = "Бібліографічний покажчик";
    public static final String BOOK = "Книга";
    public static final String CATALOG = "Каталог";
    public static final String DISSERTATION = "Дисертація";
    public static final String ELECTRONIC_RESOURCE = "Електроний ресурс";
    public static final String LEGIS_NORM_DOCUMENTS = "Нормативний документ";
    public static final String PATENT = "Патент";
    public static final String PREPRINT = "Препринт";
    public static final String STANDART = "Стандарт";
    public static final String THESIS = "Тезис";

    private String typeOfWork;

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public abstract int getId();
}
