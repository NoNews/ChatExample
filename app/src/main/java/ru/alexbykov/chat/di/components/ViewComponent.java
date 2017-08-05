package ru.alexbykov.chat.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.alexbykov.chat.App;
import ru.alexbykov.chat.activities.BaseActivity;
import ru.alexbykov.chat.di.modules.ViewModule;

/**
 * Date: 04.06.2017
 * Time: 10:30
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */


@Singleton
@Component(modules = {ViewModule.class})
public interface ViewComponent {
    void inject(App app);
    void inject(BaseActivity baseActivity);
}
