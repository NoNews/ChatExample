package ru.alexbykov.chat.activities;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.activities.base.BaseSingleActivity;
import ru.alexbykov.chat.adapters.ChatAdapter;
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
    private AppCompatEditText etInput;
    private CustomCircleImageView civPhoto;
    private ImageView ivSend;
    private ChatAdapter chatAdapter;
    private RecyclerView rvChat;
    private LinearLayoutManager chatManager;


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
        setupChatRecyclerView();
    }

    private void setupChatRecyclerView() {
        chatAdapter = new ChatAdapter();
        chatManager = new LinearLayoutManager(this);
        rvChat.setLayoutManager(chatManager);
        rvChat.setAdapter(chatAdapter);

    }

    @Override
    public void setupUX() {
        ivSend.setOnClickListener(v -> chatPresenter.onClickSend(etInput.getText().toString()));
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
    public void addMessage(MessageDTO message) {
        chatAdapter.addMessage(message);
        rvChat.getLayoutManager().scrollToPosition(chatManager.findLastVisibleItemPosition() + 1);
    }

    @Override
    public void clearInput() {
        etInput.getText().clear();
    }


    public void bindViews() {
        tvToolbarTitle = bindView(R.id.tvToolbarTitle);
        tvStatus = bindView(R.id.tvStatus);
        civPhoto = bindView(R.id.civPhoto);
        tvTyping = bindView(R.id.tvTyping);
        etInput = bindView(R.id.etInput);
        ivSend = bindView(R.id.ivSend);
        rvChat = bindView(R.id.rvChat);
    }
}
