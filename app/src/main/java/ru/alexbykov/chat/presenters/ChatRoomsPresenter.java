package ru.alexbykov.chat.presenters;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import ru.alexbykov.chat.api.ApiResponse;
import ru.alexbykov.chat.api.RestApi;
import ru.alexbykov.chat.api.models.chats.RoomDTO;
import ru.alexbykov.chat.interfaces.views.ChatRoomsView;
import ru.alexbykov.chat.utils.presenter.chat.RoomsHelper;
import ru.alexbykov.chat.utils.RxUtils;

@InjectViewState
public class ChatRoomsPresenter extends BasePresenter<ChatRoomsView> {

    @Inject
    ChatRoomsPresenter(RestApi restApi, RoomsHelper roomsHelper) {
        this.restApi = restApi;
        this.roomsHelper = roomsHelper;
        getChatRoomsRequest();
    }


    private void getChatRoomsRequest() {
        getViewState().showData(false);
        getViewState().showNetworkError(false);
        getViewState().showProgress(true);
        Disposable request =
                restApi.chatEndPoint
                        .getRooms()
                        .compose(RxUtils.httpSchedulers())
                        .subscribe(this::successChatRoom, this::handleChatRoomError);
        unSubscribeOnDestroy(request);
    }


    private void handleChatRoomError(Throwable throwable) {
        getViewState().showProgress(false);
        getViewState().showNetworkError(true);
    }

    private void successChatRoom(ApiResponse<List<RoomDTO>> response) {
        List<RoomDTO> rooms = response.getData();
        roomsHelper.addChatRooms(rooms);
        getViewState().addChatRooms(rooms);
        waitForRoomUpdate();
        getViewState().showProgress(false);
        getViewState().showData(true);
    }

    private void waitForRoomUpdate() {
        roomsHelper.setOnRoomChangedListener(room -> getViewState().updateChatRoom(room));
    }

    public void repeat() {
        getChatRoomsRequest();
    }
}
