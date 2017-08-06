package ru.alexbykov.chat.di.modules;

import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.alexbykov.chat.App;
import ru.alexbykov.chat.api.RestApi;
import ru.alexbykov.chat.cache.ChatManager;
import ru.alexbykov.chat.utils.presenter.chat.MessagesHelper;
import ru.alexbykov.chat.utils.presenter.chat.RoomsHelper;
import ru.alexbykov.chat.utils.presenter.TokenHelper;

/**
 * Date: 04.06.2017
 * Time: 10:46
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

@Module
public class RestModule {

    private TokenHelper tokenHelper;
    private RestApi restApi;
    private RoomsHelper roomsHelper;
    private MessagesHelper messagesHelper;
    private ChatManager chatManager;

    public RestModule(App app) {
        tokenHelper = new TokenHelper(PreferenceManager.getDefaultSharedPreferences(app));
        restApi = new RestApi(tokenHelper);
        roomsHelper = new RoomsHelper();
        messagesHelper = new MessagesHelper();
        chatManager = new ChatManager(PreferenceManager.getDefaultSharedPreferences(app));
    }


    @Singleton
    @Provides
    ChatManager provideChatManager() {
        return chatManager;
    }


    @Singleton
    @Provides
    MessagesHelper provideMessagesHelper() {
        return messagesHelper;
    }


    @Singleton
    @Provides
    RoomsHelper provideRoomsHelper() {
        return roomsHelper;
    }


    @Singleton
    @Provides
    RestApi provideRestApi() {
        return restApi;
    }

    @Singleton
    @Provides
    TokenHelper provideTokenHelper() {
        return tokenHelper;
    }
}

