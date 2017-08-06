package ru.alexbykov.chat.utils;

/**
 * Date: 05.08.2017
 * Time: 11:59
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class StringUtils {
    private static final int SIMPLE_TEXT_SIZE = 25;


    private StringUtils() {
    }

    public static String getSimpleText(String text) {
        return text.length() > SIMPLE_TEXT_SIZE ? text.substring(0, SIMPLE_TEXT_SIZE - 3) + "..." : text;
    }
}
