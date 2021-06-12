package com.kpi.scineticle.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextValidator {

    public boolean validateAuthorsName(String authors) {


        Pattern pattern = Pattern.compile("^(([A-ZА-ЯЁҐЄІЇ]{1}[a-zа-яёґєії]{2,}\\s[A-ZА-ЯЁҐЄІЇ]{1}\\.[A-ZА-ЯЁҐЄІЇ]{1}\\.)" +
                "*(,\\s[A-ZА-ЯЁҐЄІЇ]{1}[a-zа-яёґєії]{2,}\\s[A-ZА-ЯЁҐЄІЇ]{1}\\.[A-ZА-ЯЁҐЄІЇ]{1}\\.)*)*$");
        Matcher matcher = pattern.matcher(authors);
        boolean result = false;
        while (matcher.find()) {
            result = true;
        }
        return isNullEmpty(authors) && result;
    }

    public boolean validateNumber(String number) {
        return isNullEmpty(number) && TextUtils.isDigitsOnly(number);
    }

    public boolean validateSheet(String sheets) {
        return isNullEmpty(sheets) && (Pattern.compile("^[0-9]*-[0-9]*$").matcher(sheets).matches()
                || Pattern.compile("^[0-9]*$").matcher(sheets).matches());
    }

    public boolean validateDate(String date) {
        if (date == null) {
            return false;
        }
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatEn = new SimpleDateFormat("yyyy MMMM dd", Locale.ENGLISH);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatNumber = new SimpleDateFormat("dd.MM.yyyy");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatUkr = new SimpleDateFormat("dd MMMM yyyy", new Locale("uk", "UA"));
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatRu = new SimpleDateFormat("dd MMMM yyyy", new Locale("ru"));
        dateFormatEn.setLenient(false);
        dateFormatNumber.setLenient(false);
        dateFormatUkr.setLenient(false);
        dateFormatRu.setLenient(false);
        boolean isDateValidEn;
        boolean isDateValidNumber;
        boolean isDateValidUkr;
        boolean isDateValidRu;
        try {
            dateFormatEn.parse(date);
            System.out.println(dateFormatEn.parse(date));
            isDateValidEn = true;
        } catch (ParseException e) {
            isDateValidEn = false;
            e.printStackTrace();
        }

        try {
            dateFormatNumber.parse(date);
            isDateValidNumber = true;
        } catch (ParseException e) {
            e.printStackTrace();
            isDateValidNumber = false;
        }

        try {
            dateFormatUkr.parse(date);
            isDateValidUkr = true;
        } catch (ParseException e) {
            e.printStackTrace();
            isDateValidUkr = false;
        }

        try {
            dateFormatRu.parse(date);
            isDateValidRu = true;
        } catch (ParseException e) {
            e.printStackTrace();
            isDateValidRu = false;
        }

        return !TextUtils.isEmpty(date) && (isDateValidEn || isDateValidNumber || isDateValidUkr || isDateValidRu);
    }

    public boolean validateName(String name) {
        return isNullEmpty(name) && Pattern.compile("^[A-ZА-ЯЁҐЄІЇ]{1}.*$").matcher(name).matches();
    }

    public boolean validateCity(String city) {
        return isNullEmpty(city) && Pattern.compile("^[A-ZА-ЯЁҐЄІЇ]{1}[a-zа-яёґєіїA-ZА-ЯЁҐЄІЇ]+(?:[\\s-][A-ZА-ЯЁҐЄІЇ][a-zа-яёґєіїA-ZА-ЯЁҐЄІЇ]+)*$").matcher(city).matches();
    }

    public boolean validateYear(String year) {
        return isNullEmpty(year) && Pattern.compile("^\\d{4}$").matcher(year).matches();
    }

    public boolean validateAbbreviation(String abbreviation) {
        return isNullEmpty(abbreviation) && Pattern.compile("^[A-ZА-ЯЁҐЄІЇ]+[\\-,.;:'0-9]*").matcher(abbreviation).matches();
    }

    public boolean validateStatement(String statement) {
        return isNullEmpty(statement) && Pattern.compile("^[a-zA-Zа-яёґєіїА-ЯЁҐЄІЇ]+[a-zA-Zа-яёґєіїА-ЯЁҐЄІЇ\\s\\-,.;:0-9]*$").matcher(statement).matches();
    }

    public boolean validType(String type) {
        return isNullEmpty(type) && Pattern.compile("^[a-zа-яёґєії,.\\s]*").matcher(type).matches();
    }

    public boolean validURL(String url) {
        return isNullEmpty(url) && Pattern.compile("/((([A-Za-z]{3,9}:(?:\\/\\/)?)(?:[-;:&=\\+\\$,\\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\\+\\$,\\w]+@)[A-Za-z0-9.-]+)((?:\\/[\\+~%\\/.\\w-_]*)?\\??(?:[-\\+=&;%@.\\w_]*)#?(?:[\\w]*))?)/")
                .matcher(url).matches();
    }

    public boolean validCodeLetter(String letter) {
        return isNullEmpty(letter) && Pattern.compile("^[A-ZА-ЯЁҐЄІЇ]+[\\s:,.\\-].*$").matcher(letter).matches();
    }

    public boolean validNumberCode(String number) {
        return isNullEmpty(number) && Pattern.compile("^[0-9]+[:\\-].*$").matcher(number).matches();
    }
    private boolean isNullEmpty(String value) {
        return value != null && !TextUtils.isEmpty(value);
    }






}
