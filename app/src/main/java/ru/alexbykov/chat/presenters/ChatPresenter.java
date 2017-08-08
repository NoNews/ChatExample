package ru.alexbykov.chat.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.R;
import ru.alexbykov.chat.api.models.chats.MessageDTO;
import ru.alexbykov.chat.cache.ChatManager;
import ru.alexbykov.chat.interfaces.callbacks.helpers.OnChatChangedListener;
import ru.alexbykov.chat.interfaces.views.ChatView;
import ru.alexbykov.chat.utils.DateHelper;
import ru.alexbykov.chat.utils.PersonUtils;
import ru.alexbykov.chat.utils.presenter.Resources;
import ru.alexbykov.chat.utils.presenter.chat.ChatHelper;
import ru.alexbykov.novalid.Validator;


@InjectViewState
public class ChatPresenter extends BasePresenter<ChatView> implements OnChatChangedListener {


    @Inject
    public ChatPresenter(ChatManager chatRepository,
                         ChatHelper chatHelper,
                         Resources resources,
                         Validator validator) {
        this.chatManager = chatRepository;
        this.chatHelper = chatHelper;
        this.validator = validator;
        this.resources = resources;
        waitForChatUpdate();
        setupToolbar();
    }

    private void waitForChatUpdate() {
        chatHelper.setOnMessageChangedListener(this);
    }

    private void setupToolbar() {
        getViewState().setToolbarTitle(chatManager.getPerson().getFullName());
        getViewState().setToolbarPhoto(chatManager.getPerson().getPhotoUrl());
    }

    @Override
    public void onNewMessage(MessageDTO message) {
        message.setPerson(message.getType() == Const.MessageType.INBOX ? chatManager.getPerson() : PersonUtils.getMe());
        getViewState().addMessage(message);
    }

    @Override
    public void onPersonOffline(String lastTime) {
        getViewState().setTyping(false);
        getViewState().setStatus(resources.getString(R.string.status_offline) + " " + lastTime);
    }

    @Override
    public void onPersonOnline() {
        getViewState().setStatus(resources.getString(R.string.status_online));
    }

    @Override
    public void onIsTyping(boolean isTyping) {
        getViewState().setTyping(isTyping);
    }

    @Override
    public void onMessageDelete() {
        getViewState().deleteMessage();
    }



    public void onClickSend(String text) {
        getViewState().clearInput();
        if (validator.isValidField(text)) {
            MessageDTO message = new MessageDTO();
            message.setMessageText(text);
            message.setDate(DateHelper.getCurrentTime());
            message.setType(Const.MessageType.OUTBOX);
            onNewMessage(message);
        }
    }
}