package ru.alexbykov.chat.adapters.recycler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.api.models.chats.RoomDTO;
import ru.alexbykov.chat.custom.views.BadgeView;
import ru.alexbykov.chat.custom.views.CustomCircleImageView;


public class ChatRoomsAdapter extends BaseRecyclerViewAdapter<RoomDTO, ChatRoomsAdapter.ChatRoomViewHolder> {

    private static final int LAYOUT = R.layout.item_chat_room;

    public ChatRoomsAdapter() {
        super();
    }

    @Override
    public ChatRoomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflate(viewGroup, LAYOUT);
        return new ChatRoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatRoomViewHolder holder, int position) {
        RoomDTO room = items.get(position);
        holder.tvName.setText(room.getName());
        holder.civPhoto.load(room.getPhotoUrl());
        holder.tvLastMessage.setText(room.getLastMessageText());
        holder.tvDate.setText(room.getLastMessageDate());
        holder.badgeView.setCount(room.getUnreadMessagesCount());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.ivRead.setSelected(room.isRead());
    }

    public void updateItem(RoomDTO room) {
        findRoomAndChange(room);
        notifyDataSetChanged();
    }

    private void findRoomAndChange(RoomDTO updateRoom) {
        for (RoomDTO currentRoom : items) {
            if (currentRoom.getId() == updateRoom.getId()) {
                items.remove(currentRoom);
                items.add(0, updateRoom);
                break;
            }
        }


    }


    public static class ChatRoomViewHolder extends BaseViewHolder {

        private TextView tvName;
        private TextView tvLastMessage;
        private TextView tvDate;
        private CustomCircleImageView civPhoto;
        private BadgeView badgeView;
        private ImageView ivRead;

        public ChatRoomViewHolder(View itemView) {
            super(itemView);
            tvName = bindView(R.id.tvName);
            tvDate = bindView(R.id.tvDate);
            tvLastMessage = bindView(R.id.tvLastMessage);
            civPhoto = bindView(R.id.civPhoto);
            badgeView = bindView(R.id.badgeView);
            ivRead = bindView(R.id.ivRead);
        }
    }
}
