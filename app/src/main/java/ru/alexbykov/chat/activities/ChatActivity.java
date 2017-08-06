package ru.alexbykov.chat.activities;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.activities.base.BaseSingleActivity;
import ru.alexbykov.chat.interfaces.views.ChatView;
import ru.alexbykov.chat.presenters.ChatPresenter;
import ru.alexbykov.chat.utils.Injector;


public class ChatActivity extends BaseSingleActivity implements ChatView {

    private static final int LAYOUT = R.layout.activity_chat;

    @InjectPresenter
    ChatPresenter chatPresenter;


    @ProvidePresenter
    ChatPresenter provideChatPresenter() {
        return Injector.getPresenterComponent().getChatPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(LAYOUT);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupUI() {

    }

    @Override
    public void setupUX() {

    }

    @Override
    public void setToolbarTitle(String title) {
        setTitle(title);
    }

    @Override
    public void setToolbarPhoto(String photoUrl) {

    }

    @Override
    public void setOnline(boolean online) {

    }
}
