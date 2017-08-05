package ru.alexbykov.chat.utils;

import java.util.List;

import ru.alexbykov.chat.api.models.chats.RoomDTO;

/**
 * Date: 05.08.2017
 * Time: 1:29
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Generator {

    public static RoomDTO getRandomRoom(List<RoomDTO> rooms) {
        RoomDTO room = rooms.get(RandomUtils.getRandom(0, rooms.size() - 1));
        room.setLastMessageText(RandomUtils.getRandomLastMessage());
        room.setLastMessageDate(DateHelper.getCurrentTime());
        room.setUnreadMessagesCount(RandomUtils.getRandomMessagesCount());
        room.setRead(RandomUtils.getRandomBoolean());
        return room;
    }
}
