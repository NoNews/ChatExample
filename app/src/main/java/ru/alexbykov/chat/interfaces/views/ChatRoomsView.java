package ru.alexbykov.chat.interfaces.views;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.alexbykov.chat.api.models.chats.ChatRoomDTO;
import ru.alexbykov.chat.interfaces.utils_view.NavigatorActivityView;
import ru.alexbykov.chat.interfaces.utils_view.NetworkView;

public interface ChatRoomsView extends BaseView, NetworkView, NavigatorActivityView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void addChatRooms(List<ChatRoomDTO> rooms);

    void updateChatRoom(ChatRoomDTO room);

}
