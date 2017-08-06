package ru.alexbykov.chat.cache;

import android.content.SharedPreferences;

import ru.alexbykov.chat.api.models.chats.ChatRoomDTO;
import ru.alexbykov.chat.api.models.user.PersonDTO;

/**
 * Date: 06.08.2017
 * Time: 20:22
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class ChatManager extends BasePreferenceHelper {


    private static final String CHAT_ROOM_KEY = "chatRoom";

    private ChatRoomDTO chatRoom;


    public ChatManager(SharedPreferences preferences) {
        super(preferences);
    }


    public void setChatRoom(ChatRoomDTO chatRoom) {
        this.chatRoom = chatRoom;
        preferences.edit().putString(CHAT_ROOM_KEY, getGson().toJson(chatRoom)).apply();
    }


    public PersonDTO getPerson() {
        if (chatRoom == null || chatRoom.getId() == 0) {
            chatRoom = getGson().fromJson(preferences.getString(CHAT_ROOM_KEY, ""), ChatRoomDTO.class);
        }
        return getPersonFromRoom(chatRoom);
    }


    private PersonDTO getPersonFromRoom(ChatRoomDTO chatRoom) {
        PersonDTO person = new PersonDTO();
        person.setFullName(chatRoom.getName());
        person.setPhotoUrl(chatRoom.getPhotoUrl());
        return person;
    }
}
