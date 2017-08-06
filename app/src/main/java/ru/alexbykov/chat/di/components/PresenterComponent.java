package ru.alexbykov.chat.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.alexbykov.chat.App;
import ru.alexbykov.chat.di.modules.RestModule;
import ru.alexbykov.chat.di.modules.UtilsModule;
import ru.alexbykov.chat.presenters.ChatPresenter;
import ru.alexbykov.chat.presenters.ChatRoomsPresenter;
import ru.alexbykov.chat.presenters.SplashPresenter;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Singleton
@Component(modules = {RestModule.class, UtilsModule.class})

public interface PresenterComponent {
    //@formatter:off
    void inject(App app);
    ChatRoomsPresenter getChatRoomPresenter();
    SplashPresenter getSplashPresenter();
    ChatPresenter getChatPresenter();}
