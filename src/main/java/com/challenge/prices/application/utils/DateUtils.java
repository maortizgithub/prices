package com.challenge.prices.application.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static final String DATE_PATTERN = "dd/MM/yyyy HH:mm";

    public static Date getDateFromString(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        return simpleDateFormat.parse(date);
    }
}
