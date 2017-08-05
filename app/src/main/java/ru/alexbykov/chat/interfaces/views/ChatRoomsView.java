package ru.alexbykov.chat.interfaces.views;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.alexbykov.chat.api.models.chats.RoomDTO;
import ru.alexbykov.chat.interfaces.utils_view.NetworkView;

public interface ChatRoomsView extends BaseView, NetworkView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void addChatRooms(List<RoomDTO> rooms);

    void updateChatRoom(RoomDTO room);

}
