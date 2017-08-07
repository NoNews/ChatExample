package ru.alexbykov.chat.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.activities.base.BaseSingleActivity;
import ru.alexbykov.chat.api.models.chats.MessageDTO;
import ru.alexbykov.chat.custom.views.CustomCircleImageView;
import ru.alexbykov.chat.interfaces.views.ChatView;
import ru.alexbykov.chat.presenters.ChatPresenter;
import ru.alexbykov.chat.utils.Injector;


public class ChatActivity extends BaseSingleActivity implements ChatView {

    private static final int LAYOUT = R.layout.activity_chat;

    @InjectPresenter
    ChatPresenter chatPresenter;

    private TextView tvToolbarTitle;
    private TextView tvStatus;
    private TextView tvTyping;
    private CustomCircleImageView civPhoto;


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
        bindViews();
    }

    @Override
    public void setupUX() {

    }

    @Override
    public void setToolbarTitle(String title) {
        tvToolbarTitle.setText(title);
    }

    @Override
    public void setToolbarPhoto(String photoUrl) {
        civPhoto.load(photoUrl);
    }

    @Override
    public void setStatus(String status) {
        runOnUiThread(() -> tvStatus.setText(status));
    }

    @Override
    public void setTyping(boolean isTyping) {
        if (isTyping) {
            showView(tvTyping);
            hideView(tvStatus);
        } else {
            hideView(tvTyping);
            showView(tvStatus);
        }
    }

    @Override
    public void addInboxMessage(MessageDTO message) {

    }

    @Override
    public void addOutboxMessage(MessageDTO message) {

    }


    public void bindViews() {
        tvToolbarTitle = bindView(R.id.tvToolbarTitle);
        tvStatus = bindView(R.id.tvStatus);
        civPhoto = bindView(R.id.civPhoto);
        tvTyping = bindView(R.id.tvTyping);
    }
}
