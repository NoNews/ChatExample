package ru.alexbykov.chat;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class Const {

    public static class Url {
        public static final String API_PRODACTION = "https://api.myjson.com/bins/";
        public static final String AUTHORIZATION = "Authorization";
    }

    public static class MessageType {
        private MessageType() {
        }

        public static final int INBOX = 1;
        public static final int OUTBOX = 2;
    }


    public static class MessageStatus {
        private MessageStatus() {
        }
        public static final int READ = 1;
        public static final int CHANGE = 2;
        public static final int DELETE = 3;
    }


    public enum Update {
        ROOM_UPDATE, CHAT_START, CHAT_UPDATE, DELAY_START
    }

    public enum ChatAction {
        MESSAGE_NEW, TYPING_START, TYPING_END, MESSAGE_DELETE
    }


}
