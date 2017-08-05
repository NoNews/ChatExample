package ru.alexbykov.chat.interfaces.callbacks.updater;

import ru.alexbykov.chat.Const;

/**
 * Date: 05.08.2017
 * Time: 1:23
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public interface UpdateListener {
    void onUpdate(Const.Update update);
}
