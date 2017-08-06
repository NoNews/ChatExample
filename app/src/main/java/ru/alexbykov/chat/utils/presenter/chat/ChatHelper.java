package ru.alexbykov.chat.utils.presenter.chat;

import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.api.models.chats.MessageDTO;
import ru.alexbykov.chat.interfaces.callbacks.helpers.OnChatChangedListener;
import ru.alexbykov.chat.interfaces.callbacks.updater.UpdateListener;
import ru.alexbykov.chat.utils.DateHelper;
import ru.alexbykov.chat.utils.presenter.RxUpdater;

/**
 * Date: 04.08.2017
 * Time: 23:08
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class ChatHelper implements UpdateListener {

    private OnChatChangedListener onMessageChangedListener;
    private RxUpdater rxUpdater;


    public void setOnMessageChangedListener(OnChatChangedListener onMessageChangedListener) {
        this.onMessageChangedListener = onMessageChangedListener;
        rxUpdater = new RxUpdater(this);
        rxUpdater.startChatUpdate();
    }


    public void deleteMessage(int messageId) {
        if (isValidListener()) {
            onMessageChangedListener.onMessageWasDeleted(messageId);
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

    @Override
    public void onUpdate(Const.Update update) {
        switch (update) {
            case DELAY:
                onMessageChangedListener.onPersonOffline(DateHelper.getCurrentTime());
                break;
            case CHAT:
                onMessageChangedListener.onPersonOnline();
                break;
        }

    }

    public void unsubscribe() {
        rxUpdater.disposeChat();
        onMessageChangedListener = null;
    }
}
