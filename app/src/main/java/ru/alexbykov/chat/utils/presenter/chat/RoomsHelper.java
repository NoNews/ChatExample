package ru.alexbykov.chat.utils.presenter.chat;

import java.util.List;

import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.api.models.chats.RoomDTO;
import ru.alexbykov.chat.interfaces.callbacks.helpers.OnRoomChangedListener;
import ru.alexbykov.chat.interfaces.callbacks.updater.UpdateListener;
import ru.alexbykov.chat.utils.Generator;
import ru.alexbykov.chat.utils.presenter.RxUpdater;

/**
 * Date: 04.08.2017
 * Time: 22:57
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class RoomsHelper implements UpdateListener {

    private OnRoomChangedListener onRoomChangedListener;
    private RxUpdater rxUpdater;
    private List<RoomDTO> rooms;

    public RoomsHelper() {
        rxUpdater = new RxUpdater(this);
    }

    public void setOnRoomChangedListener(OnRoomChangedListener onRoomChangedListener) {
        rxUpdater.startRoomUpdate();
        this.onRoomChangedListener = onRoomChangedListener;
    }

    private void updateRoom(RoomDTO room) {
        if (onRoomChangedListener != null) {
            onRoomChangedListener.onRoomChange(room);
        }
    }

    @Override
    public void onUpdate(Const.Update update) {
        if (update == Const.Update.ROOM) {
            updateRoom(Generator.getRandomRoom(rooms));
        }
    }

    public void addChatRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    public void unsubscribe() {
        rxUpdater.unsubscribe();
    }
}
