package ru.alexbykov.chat.utils;

import ru.alexbykov.chat.di.components.PresenterComponent;
import ru.alexbykov.chat.di.components.ViewComponent;

/**
 * Date: 25.06.2017
 * Time: 15:35
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Injector {

    private static PresenterComponent presenterComponent;
    private static ViewComponent viewComponent;


    public static PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }

    public static void setPresenterComponent(PresenterComponent presenterComponent) {
        Injector.presenterComponent = presenterComponent;
    }

    public static ViewComponent getViewComponent() {
        return viewComponent;
    }

    public static void setViewComponent(ViewComponent viewComponent) {
        Injector.viewComponent = viewComponent;
    }

}
