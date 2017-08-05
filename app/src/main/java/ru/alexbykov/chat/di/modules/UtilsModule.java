package ru.alexbykov.chat.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.alexbykov.chat.App;
import ru.alexbykov.chat.utils.presenter.Resources;

/**
 * Date: 04.06.2017
 * Time: 11:06
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

@Module
public class UtilsModule {

    private App app;

    public UtilsModule(App app) {
        this.app = app;
    }

    @Provides
    Resources provideResources() {
        return new Resources(app);
    }

}
