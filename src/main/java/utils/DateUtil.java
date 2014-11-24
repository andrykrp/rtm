package utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static final String FULL_DATE_FORMAT = "dd.MM.yyyy";

    public static Date stringToDate(String source, String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format)
                .withLocale(new Locale("ru", "RU"));
        DateTime dt = formatter.parseDateTime(source);
        return dt.toDate();
    }

    public static String dateToString(Date source, String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format)
                .withLocale(new Locale("ru", "RU"));
        DateTime dt = new DateTime(source);
        return formatter.print(dt);
    }
}
