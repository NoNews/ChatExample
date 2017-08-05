package ru.alexbykov.chat.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.chat.activities.ChatRoomsActivity;
import ru.alexbykov.chat.api.RestApi;
import ru.alexbykov.chat.interfaces.views.SplashView;
import ru.alexbykov.chat.utils.presenter.TokenHelper;


@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    SplashPresenter(RestApi restApi, TokenHelper preferenceHelper) {
        this.restApi = restApi;
        this.tokenHelper = preferenceHelper;
        startNextActivity();
    }


    private void startNextActivity() {
        if (tokenHelper.isFirstRun()) {
            getViewState().startActivity(ChatRoomsActivity.class);
        }
    }

}
