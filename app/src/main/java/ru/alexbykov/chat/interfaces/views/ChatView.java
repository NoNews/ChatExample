package ru.alexbykov.chat.interfaces.views;


import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.alexbykov.chat.api.models.chats.MessageDTO;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface ChatView extends BaseView {

    void setToolbarTitle(String title);
    void setToolbarPhoto(String photoUrl);
    void setStatus(String status);
    void setTyping(boolean isTyping);
    void addInboxMessage(MessageDTO message);
    void addOutboxMessage(MessageDTO message);
}
