package ru.alexbykov.chat.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.alexbykov.chat.App;
import ru.alexbykov.chat.utils.AnimationHelper;

/**
 * Date: 04.06.2017
 * Time: 10:18
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

@Module
public class ViewModule {



    private AnimationHelper animationHelper;

    public ViewModule(App app) {
        animationHelper = new AnimationHelper(app);
    }


    @Provides
    @Singleton
    AnimationHelper provideAnimationHelper() {
        return animationHelper;
    }
}
