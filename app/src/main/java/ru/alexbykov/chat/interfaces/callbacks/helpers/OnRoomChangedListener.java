package ru.alexbykov.chat.interfaces.callbacks.helpers;

import ru.alexbykov.chat.api.models.chats.RoomDTO;

/**
 * Date: 04.08.2017
 * Time: 22:58
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public interface OnRoomChangedListener {
    void onRoomChange(RoomDTO room);
}
