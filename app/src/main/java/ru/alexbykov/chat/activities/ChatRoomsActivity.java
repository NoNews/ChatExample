package ru.alexbykov.chat.activities;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.adapters.recycler.ChatRoomsAdapter;
import ru.alexbykov.chat.api.models.chats.ChatRoomDTO;
import ru.alexbykov.chat.interfaces.views.ChatRoomsView;
import ru.alexbykov.chat.presenters.ChatRoomsPresenter;
import ru.alexbykov.chat.utils.Injector;

public class ChatRoomsActivity extends BaseNetworkActivity implements ChatRoomsView {

    private static final int LAYOUT = R.layout.activity_chat_rooms;

    @InjectPresenter
    ChatRoomsPresenter chatRoomsPresenter;

    private RecyclerView rvChatRooms;
    private ChatRoomsAdapter chatRoomsAdapter;

    @ProvidePresenter
    ChatRoomsPresenter provideMainActivityPresenter() {
        return Injector.getPresenterComponent().getMainActivityPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(LAYOUT);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupUI() {
        bindViews();
        toolbar.setTitle(R.string.chat_rooms_activity);
        setupChatRoomsRecyclerView();
    }

    @Override
    public void setupUX() {
        btnRepeat.setOnClickListener(v->chatRoomsPresenter.repeat());
    }

    @Override
    public void addChatRooms(List<ChatRoomDTO> rooms) {
        chatRoomsAdapter.addItems(rooms);
    }

    @Override
    public void updateChatRoom(ChatRoomDTO room) {
        chatRoomsAdapter.updateItem(room);
    }

    private void setupChatRoomsRecyclerView() {
        chatRoomsAdapter = new ChatRoomsAdapter();
        rvChatRooms.setLayoutManager(new LinearLayoutManager(this));
        rvChatRooms.setAdapter(chatRoomsAdapter);
    }


    private void bindViews() {
        rvChatRooms = bindView(R.id.rvChatRooms);
        toolbar = bindView(R.id.toolbar);
        progressBar = bindView(R.id.progressBar);
        ltData = bindView(R.id.ltData);
        ltError = bindView(R.id.ltError);
        btnRepeat = bindView(R.id.btnRepeat);
    }

}
