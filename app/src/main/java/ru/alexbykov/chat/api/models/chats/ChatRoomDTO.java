package ru.alexbykov.chat.api.models.chats;

import com.google.gson.annotations.SerializedName;

import ru.alexbykov.chat.utils.StringUtils;

/**
 * Date: 04.08.2017
 * Time: 21:12
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 *         Данная модель — комата чата. Передаётся в списке чатов
 */
public class ChatRoomDTO {

    private int id;
    private String name;
    @SerializedName("unread_messages_count")
    private int unreadMessagesCount;
    @SerializedName("last_message_date")
    private String lastMessageDate;
    @SerializedName("last_message_text")
    private String lastMessageText;
    @SerializedName("photo")
    private String photoUrl;
    private boolean isRead;

    public ChatRoomDTO(int id, String name, int unreadMessagesCount, String lastMessageDate, String lastMessageText) {
        this.id = id;
        this.name = name;
        this.unreadMessagesCount = unreadMessagesCount;
        this.lastMessageDate = lastMessageDate;
        this.lastMessageText = lastMessageText;
    }


    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isRead() {
        return isRead;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getLastMessageText() {
        return StringUtils.getSimpleText(lastMessageText);
    }

    public void setLastMessageText(String lastMessageText) {
        this.lastMessageText = lastMessageText;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnreadMessagesCount() {
        return unreadMessagesCount;
    }

    public void setUnreadMessagesCount(int unreadMessagesCount) {
        this.unreadMessagesCount = unreadMessagesCount;
    }

    public String getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(String lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatRoomDTO roomDTO = (ChatRoomDTO) o;

        if (id != roomDTO.id) return false;
        if (unreadMessagesCount != roomDTO.unreadMessagesCount) return false;
        if (!name.equals(roomDTO.name)) return false;
        if (!lastMessageDate.equals(roomDTO.lastMessageDate)) return false;
        return lastMessageText.equals(roomDTO.lastMessageText);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + unreadMessagesCount;
        result = 31 * result + lastMessageDate.hashCode();
        result = 31 * result + lastMessageText.hashCode();
        return result;
    }

    public void update(ChatRoomDTO updateRoom) {
        setLastMessageDate(updateRoom.getLastMessageDate());
        setLastMessageText(updateRoom.getLastMessageText());
        setUnreadMessagesCount(updateRoom.getUnreadMessagesCount());
        setName(updateRoom.getName());
    }
}
