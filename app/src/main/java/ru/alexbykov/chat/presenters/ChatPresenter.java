package ru.alexbykov.chat.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.api.models.chats.MessageDTO;
import ru.alexbykov.chat.cache.ChatManager;
import ru.alexbykov.chat.interfaces.callbacks.helpers.OnChatChangedListener;
import ru.alexbykov.chat.interfaces.views.ChatView;
import ru.alexbykov.chat.utils.presenter.Resources;
import ru.alexbykov.chat.utils.presenter.chat.ChatHelper;


@InjectViewState
public class ChatPresenter extends BasePresenter<ChatView> implements OnChatChangedListener {


    @Inject
    public ChatPresenter(ChatManager chatRepository, ChatHelper chatHelper, Resources resources) {
        this.chatManager = chatRepository;
        this.chatHelper = chatHelper;
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
        message.setPerson(chatManager.getPerson());
        getViewState().addInboxMessage(message);
    }

    @Override
    public void onPersonOffline(String lastTime) {
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


    public void onClickSend(String text) {
        getViewState().clearInput();
    }
}