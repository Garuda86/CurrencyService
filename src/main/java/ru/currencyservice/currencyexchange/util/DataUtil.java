package ru.currencyservice.currencyexchange.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    public static String getToday() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String getYesterday() {
        return LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
