package ru.alexbykov.chat.utils;

import ru.alexbykov.chat.api.models.user.PersonDTO;

/**
 * Date: 08.08.2017
 * Time: 1:38
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class PersonUtils {
    private PersonUtils() {
    }

    public static PersonDTO getMe() {
        PersonDTO person = new PersonDTO();
        person.setFullName("Алексей Быков");
        person.setPhotoUrl("https://pp.userapi.com/c631626/v631626921/342c1/acIwxieE0Sw.jpg");
        return person;
    }
}
