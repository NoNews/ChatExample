package ru.alexbykov.chat.utils.presenter.chat;

import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.interfaces.callbacks.helpers.OnChatChangedListener;
import ru.alexbykov.chat.interfaces.callbacks.updater.UpdateListener;
import ru.alexbykov.chat.utils.DateHelper;
import ru.alexbykov.chat.utils.Generator;
import ru.alexbykov.chat.utils.RandomUtils;
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

    @Override
    public void onUpdate(Const.Update update) {
        switch (update) {
            case DELAY_START:
                onMessageChangedListener.onPersonOffline(DateHelper.getCurrentTime());
                break;
            case CHAT_START:
                onMessageChangedListener.onPersonOnline();
                break;
            case CHAT_UPDATE:
                updateChat();
                break;
        }

    }

    private void updateChat() {
        switch (RandomUtils.randomEnum(Const.ChatAction.class)) {
            case NEW_MESSAGE:
                onMessageChangedListener.onNewMessage(Generator.getNewMessage());
                break;
            case TYPING_START:
                onMessageChangedListener.onIsTyping(true);
                break;
            case TYPING_END:
                onMessageChangedListener.onIsTyping(false);
                break;

        }
    }

    public void unsubscribe() {
        rxUpdater.disposeChat();
        onMessageChangedListener = null;
    }
}
