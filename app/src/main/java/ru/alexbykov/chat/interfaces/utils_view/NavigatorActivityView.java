package ru.alexbykov.chat.interfaces.utils_view;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.alexbykov.chat.activities.base.BaseActivity;
import ru.alexbykov.chat.interfaces.views.BaseView;

/**
 * Date: 04.06.2017
 * Time: 12:02
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
@StateStrategyType(OneExecutionStateStrategy.class)
public interface NavigatorActivityView extends BaseView {
    void startActivity(Class<? extends BaseActivity> activityClass);
    void startActivityForResult(Class<? extends BaseActivity> activityClass, int requestCode);
}
