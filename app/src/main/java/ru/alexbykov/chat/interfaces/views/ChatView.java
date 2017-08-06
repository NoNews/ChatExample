package ru.alexbykov.chat.interfaces.views;


import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface ChatView extends BaseView {

    void setToolbarTitle(String title);

    void setToolbarPhoto(String photoUrl);

    void setStatus(String status);
}
