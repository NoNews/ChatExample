package ru.alexbykov.chat.api.endpoints;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.alexbykov.chat.api.ApiResponse;
import ru.alexbykov.chat.api.models.chats.ChatRoomDTO;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public interface ChatEndpoint {


    //              8832p
//    https://api.myjson.com/bins/6qb49
    @GET("6qb49")
    Observable<ApiResponse<List<ChatRoomDTO>>> getRooms();

}
