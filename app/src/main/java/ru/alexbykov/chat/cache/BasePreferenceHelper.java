package ru.alexbykov.chat.cache;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Alex Bykov on 22.05.2017.
 * You can contact me at: me@alexbykov.ru.
 */

abstract class BasePreferenceHelper {

    private Gson gson;
    SharedPreferences preferences;


    BasePreferenceHelper(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
}
