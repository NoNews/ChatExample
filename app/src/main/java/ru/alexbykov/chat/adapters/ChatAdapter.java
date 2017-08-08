package ru.alexbykov.chat.adapters;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.R;
import ru.alexbykov.chat.adapters.recycler.BaseChatAdapter;
import ru.alexbykov.chat.adapters.recycler.BaseViewHolder;
import ru.alexbykov.chat.api.models.chats.MessageDTO;
import ru.alexbykov.chat.custom.views.CustomCircleImageView;
import ru.alexbykov.chat.utils.MessageUtils;


public class ChatAdapter extends BaseChatAdapter {

    public ChatAdapter() {
        items = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        MessageDTO message = items.get(position);
        if (getItemViewType(position) == Const.MessageType.INBOX) {
            ChatInboxHolder chatHolder = (ChatInboxHolder) holder;
            setupInboxMessage(chatHolder, message);

        } else {
            ChatOutboxHolder outboxHolder = (ChatOutboxHolder) holder;
            setupOutboxMessage(outboxHolder, message);
        }
    }

    private void setupOutboxMessage(ChatOutboxHolder outboxHolder, MessageDTO message) {
        outboxHolder.tvMessage.setText(message.getMessageText());
        outboxHolder.tvDate.setText(message.getDate());
        outboxHolder.civPhoto.load(message.getPerson().getPhotoUrl());
    }

    private void setupInboxMessage(ChatInboxHolder chatHolder, MessageDTO message) {
        chatHolder.tvMessage.setText(message.getMessageText());
        chatHolder.tvDate.setText(message.getDate());
        chatHolder.civPhoto.load(message.getPerson().getPhotoUrl());
    }


    public void addMessage(MessageDTO message) {
        add(message, items.size());
    }


    public void deleteMessage() {
        if (isValidItems()) {
            remove(items.size() - 1);
        }
    }



    public static class ChatInboxHolder extends BaseViewHolder {

        private TextView tvDate;
        private TextView tvMessage;
        private CustomCircleImageView civPhoto;

        public ChatInboxHolder(View itemView) {
            super(itemView);
            tvDate = bindView(R.id.tvDate);
            tvMessage = bindView(R.id.tvMessage);
            civPhoto = bindView(R.id.civPhoto);
        }
    }

    public static class ChatOutboxHolder extends BaseViewHolder {

        private TextView tvDate;
        private TextView tvMessage;
        private CustomCircleImageView civPhoto;

        public ChatOutboxHolder(View itemView) {
            super(itemView);
            tvDate = bindView(R.id.tvDate);
            tvMessage = bindView(R.id.tvMessage);
            civPhoto = bindView(R.id.civPhoto);
        }
    }
}
