package ru.alexbykov.chat.adapters;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.adapters.recycler.BaseRecyclerViewAdapter;
import ru.alexbykov.chat.adapters.recycler.BaseViewHolder;
import ru.alexbykov.chat.api.models.chats.InboxMessage;
import ru.alexbykov.chat.api.models.chats.MessageDTO;
import ru.alexbykov.chat.api.models.chats.OutboxMessage;


public class ChatAdapter extends BaseRecyclerViewAdapter<MessageDTO, BaseViewHolder> {

    private static final int LAYOUT = R.layout.item_chat;


    public ChatAdapter() {
        items = new ArrayList<>();
    }

    @Override
    public ChatInboxHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflate(viewGroup, LAYOUT);
        return new ChatInboxHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }


    public void addInboxMessage(MessageDTO message) {
        InboxMessage inboxMessage = (InboxMessage) message;
        add(inboxMessage, items.size());
    }

    public void addOutboxMessage(MessageDTO message) {
        OutboxMessage outboxMessage = (OutboxMessage) message;
        add(outboxMessage, items.size());
    }


    public static class ChatInboxHolder extends BaseViewHolder {

        public ChatInboxHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ChatOutboxHolder extends BaseViewHolder {

        public ChatOutboxHolder(View itemView) {
            super(itemView);
        }
    }
}
