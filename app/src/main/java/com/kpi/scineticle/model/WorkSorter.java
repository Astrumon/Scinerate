package com.kpi.scineticle.model;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorkSorter {
    public static final String SORT_BY_TYPE = "SORT_BY_TYPE";
    public static final String SORT_BY_AUTHORS = "SORT_BY_AUTHORS";
    public static final String SORT_BY_NAME = "SORT_BY_NAME";
    public static final String SORT_BY_DATE = "SORT_BY_DATE";

    public ArrayList<Data> sortByTypeWork(List<Data> data) {
        Comparator<Data> comparator = new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.typeWork != null && o2.typeWork != null) {
                    return o1.typeWork.compareTo(o2.typeWork);
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(data, comparator);

        return new ArrayList<>(data);
    }

    public ArrayList<Data> sortByNew(List<Data> data) {
        Comparator<Data> comparator = new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return -(o1.id - o2.id);
            }
        };
        Collections.sort(data, comparator);

        return new ArrayList<>(data);
    }
    public ArrayList<Data> sortByAuthorsName(List<Data> data) {
        Comparator<Data> comparator = new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.authors != null && o2.authors != null) {
                    return o1.authors.compareTo(o2.authors);
                } else if (o1.authors != null){

                    return o1.authors.compareTo("zzzzzzzzzzzzzzzz");
                } else if (o2.authors != null) {
                    return "zzzzzzzzzzz".compareTo(o2.authors);
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(data, comparator);

        return new ArrayList<>(data);
    }

    public ArrayList<Data> sortByName(List<Data> data) {


        Comparator<Data> comparator = new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.name != null && o2.name != null) {
                    return o1.name.compareTo(o2.name);
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(data, comparator);

        return new ArrayList<>(data);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<Data> sortByDate(List<Data> data) {
        @SuppressLint("SimpleDateFormat") DateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        Comparator<Data> comparator = new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.date != null && o2.date != null) {
                    try {
                        return -f.parse(o1.date).compareTo(f.parse(o2.date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0;
                    }
                } else if (o1.date != null) {
                    try {
                        return -f.parse(o1.date).compareTo(f.parse("01.01.0001"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0;
                    }
                } else if (o2.date != null) {
                    try {
                        return -f.parse("01.01.0001").compareTo(f.parse(o2.date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(data, comparator);

        return new ArrayList<>(data);
    }
}
