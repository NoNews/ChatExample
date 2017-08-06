package ru.alexbykov.chat;


import android.app.Application;
import android.support.annotation.NonNull;

import ru.alexbykov.chat.di.components.DaggerPresenterComponent;
import ru.alexbykov.chat.di.components.DaggerViewComponent;
import ru.alexbykov.chat.di.components.PresenterComponent;
import ru.alexbykov.chat.di.components.ViewComponent;
import ru.alexbykov.chat.di.modules.RestModule;
import ru.alexbykov.chat.di.modules.UtilsModule;
import ru.alexbykov.chat.di.modules.ViewModule;
import ru.alexbykov.chat.utils.Injector;
import timber.log.Timber;


/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger2();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void setupDagger2() {
        Injector.setPresenterComponent(getPresenterComponent());
        Injector.setViewComponent(getViewComponent());
    }

    @NonNull
    private PresenterComponent getPresenterComponent() {
        PresenterComponent presenterComponent = DaggerPresenterComponent.builder()
                .restModule(new RestModule(this))
                .utilsModule(new UtilsModule(this))
                .build();
        presenterComponent.inject(this);
        return presenterComponent;
    }

    @NonNull
    private ViewComponent getViewComponent() {
        ViewComponent viewComponent = DaggerViewComponent.builder()
                .viewModule(new ViewModule(this))
                .build();
        viewComponent.inject(this);
        return viewComponent;
    }



}
