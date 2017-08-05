package ru.alexbykov.chat.utils.presenter.chat;

import ru.alexbykov.chat.api.models.chats.MessageDTO;
import ru.alexbykov.chat.interfaces.callbacks.helpers.OnMessageChangedListener;

/**
 * Date: 04.08.2017
 * Time: 23:08
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class MessagesHelper {

    private OnMessageChangedListener onMessageChangedListener;


    public void setOnMessageChangedListener(OnMessageChangedListener onMessageChangedListener) {
        this.onMessageChangedListener = onMessageChangedListener;
    }


    public void deleteMessage(int messageId) {
        if (isValidListener()) {
            onMessageChangedListener.onMessagwWasDeleted(messageId);
        }
    }


    public void readMessage(int messageId) {
        if (isValidListener()) {
            onMessageChangedListener.onMessageWasRead(messageId);
        }
    }

    public void newMessage(MessageDTO message) {
        if (isValidListener()) {
            onMessageChangedListener.onNewMessage(message);
        }
    }

    private boolean isValidListener() {
        return onMessageChangedListener != null;
    }
}
