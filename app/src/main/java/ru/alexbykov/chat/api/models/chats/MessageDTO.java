package ru.alexbykov.chat.api.models.chats;

import ru.alexbykov.chat.api.models.user.PersonDTO;

/**
 * Date: 04.08.2017
 * Time: 21:15
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class MessageDTO {

    private String messageText;
    private String date;
    private PersonDTO person;


    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }
}
