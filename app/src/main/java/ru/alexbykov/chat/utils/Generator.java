package ru.alexbykov.chat.utils;

import java.util.List;

import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.api.models.chats.ChatRoomDTO;
import ru.alexbykov.chat.api.models.chats.MessageDTO;

/**
 * Date: 05.08.2017
 * Time: 1:29
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Generator {

    public static ChatRoomDTO getRandomRoom(List<ChatRoomDTO> rooms) {
        ChatRoomDTO room = rooms.get(RandomUtils.getRandom(0, rooms.size() - 1));
        room.setLastMessageText(RandomUtils.getRandomLastMessage());
        room.setLastMessageDate(DateHelper.getCurrentTime());
        room.setUnreadMessagesCount(RandomUtils.getRandomMessagesCount());
        room.setRead(RandomUtils.getRandomBoolean());
        return room;
    }

    public static MessageDTO getNewMessage() {
        MessageDTO message = new MessageDTO();
        message.setMessageText(RandomUtils.getRandomLastMessage());
        message.setDate(DateHelper.getCurrentTime());
        message.setType(RandomUtils.getRandom(Const.MessageType.INBOX, Const.MessageType.OUTBOX));
        return message;
    }
}
