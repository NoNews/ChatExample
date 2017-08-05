package ru.alexbykov.chat.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Date: 05.08.2017
 * Time: 11:41
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class DateHelper {


    private static final String CHAT_TIME_PATTERN = "HH:MM:ss";

    private DateHelper() {
    }


    public static String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        return getDateFromPattern(calendar, CHAT_TIME_PATTERN);
    }


    private static String getDateFromPattern(Calendar calendar, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return StringUtils.removeZero(df.format(calendar.getTime()));
    }
}
