package com.kpi.scineticle.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkSearcher {
    private String search;
    public static final String SEARCH_BY_TYPE = "SEARCH_BY_TYPE";
    public static final String SEARCH_BY_AUTHORS = "SEARCH_BY_AUTHORS";
    public static final String SEARCH_BY_NAME = "SEARCH_BY_NAME";
    public static final String SEARCH_BY_DATE = "SEARCH_BY_DATE";

    public ArrayList<Data> searchByType(List<Data> data, String type) {
        ArrayList<Data> result = new ArrayList<>();
        for (Data value : data) {
            if (value.typeWork.equals(type)) {
                result.add(value);
            }
        }

        return result;
    }

    public ArrayList<Data> searchByName(List<Data> data, String name) {
        ArrayList<Data> result = new ArrayList<>();
        for (Data value : data) {
            if (value.name.toLowerCase().contains(name.toLowerCase()) || value.name.toUpperCase().contains(name.toUpperCase())) {
                result.add(value);
            }
        }

        return result;
    }

    public ArrayList<Data> searchByDate(List<Data> data, String date) {
        ArrayList<Data> result = new ArrayList<>();
        for (Data value : data) {
            if (value.date != null && value.date.equals(date)) {
                result.add(value);
            }
        }

        return result;
    }

    public ArrayList<Data> searchByAuthors(List<Data> data, String authors) {
        ArrayList<Data> result = new ArrayList<>();
        for (Data value : data) {
            if (value.authors != null && (value.authors.toLowerCase().contains(authors.toLowerCase()) || value.authors.toUpperCase().contains(authors.toUpperCase()))) {
                result.add(value);
            }
        }

        return result;
    }
}
