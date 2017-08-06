package ru.alexbykov.chat.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.chat.interfaces.views.ChatView;


@InjectViewState
public class ChatPresenter extends BasePresenter<ChatView> {

    @Inject
    public ChatPresenter() {

    }

}