package ru.alexbykov.chat.interfaces.callbacks.helpers;

import ru.alexbykov.chat.api.models.chats.MessageDTO;

/**
 * Date: 04.08.2017
 * Time: 23:12
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public interface OnChatChangedListener {
    void onNewMessage(MessageDTO message);
    void onMessageWasDeleted(int messageId);
    void onMessageWasRead(int messageId);
    void onPersonOffline(String lastTime);
    void onPersonOnline();
    void onIsTyping(boolean isTyping);

}
