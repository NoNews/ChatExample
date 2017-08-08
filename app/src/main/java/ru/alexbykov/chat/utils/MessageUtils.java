package ru.alexbykov.chat.utils;

import java.util.List;

import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.api.models.chats.MessageDTO;

/**
 * Created by Alex Bykov on 08.08.2017.
 * You can contact me at: me@alexbykov.ru.
 */

public class MessageUtils {

    public static void readOutbox(List<MessageDTO> items) {
        for (int i = 0; i < items.size(); i++) {
            MessageDTO message = items.get(i);
            if (items.get(i).getType() == Const.MessageType.OUTBOX) {
                message.setType(Const.MessageStatus.READ);
            }
        }
    }
}
