package ru.alexbykov.chat.api.models.chats;

import java.util.List;

import ru.alexbykov.chat.api.models.user.PersonDTO;

/**
 * Date: 04.08.2017
 * Time: 21:12
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class ChatDTO {

    private int unreadMessagesCount;//Количество непрочитанных сообщений
    private List<PersonDTO> persons;//Кто кроме меня участвует в чате
    private List<MessageDTO> messages;//сообщения

    public int getUnreadMessagesCount() {
        return unreadMessagesCount;
    }

    public void setUnreadMessagesCount(int unreadMessagesCount) {
        this.unreadMessagesCount = unreadMessagesCount;
    }

    public List<PersonDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDTO> persons) {
        this.persons = persons;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
