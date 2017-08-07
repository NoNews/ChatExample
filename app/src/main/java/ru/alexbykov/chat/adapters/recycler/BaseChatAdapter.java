package ru.alexbykov.chat.adapters.recycler;

import android.view.View;
import android.view.ViewGroup;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.adapters.ChatAdapter;
import ru.alexbykov.chat.api.models.chats.InboxMessage;
import ru.alexbykov.chat.api.models.chats.MessageDTO;

/**
 * Date: 08.08.2017
 * Time: 0:16
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class BaseChatAdapter extends BaseRecyclerViewAdapter<MessageDTO, BaseViewHolder> {


    private static final int INBOX_MESSAGE = 1;
    private static final int OUTBOX_MESSAGE = 2;

    private static final int LAYOUT_INBOX = R.layout.item_chat;
    private static final int LAYOUT_OUTBOX = R.layout.item_chat;

    @Override
    public int getItemViewType(int position) {
        MessageDTO message = items.get(position);
        return message instanceof InboxMessage ? INBOX_MESSAGE : OUTBOX_MESSAGE;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == LAYOUT_INBOX) {
            view = inflate(parent, LAYOUT_INBOX);
            return new ChatAdapter.ChatInboxHolder(view);
        } else {
            view = inflate(parent, LAYOUT_OUTBOX);
            return new ChatAdapter.ChatOutboxHolder(view);
        }
    }

}
