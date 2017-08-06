package ru.alexbykov.chat.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.chat.cache.ChatManager;
import ru.alexbykov.chat.interfaces.views.ChatView;


@InjectViewState
public class ChatPresenter extends BasePresenter<ChatView> {


    @Inject
    public ChatPresenter(ChatManager chatRepository) {
        this.chatRepository = chatRepository;
        setupToolbar();
    }

    private void setupToolbar() {
        getViewState().setToolbarTitle(chatRepository.getPerson().getFullName());
    }

}