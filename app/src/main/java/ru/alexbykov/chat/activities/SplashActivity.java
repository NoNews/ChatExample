package ru.alexbykov.chat.activities;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.chat.activities.base.BaseActivity;
import ru.alexbykov.chat.interfaces.views.SplashView;
import ru.alexbykov.chat.presenters.SplashPresenter;
import ru.alexbykov.chat.utils.Injector;


public class SplashActivity extends BaseActivity implements SplashView {


    @InjectPresenter
    SplashPresenter splashPresenter;

    @ProvidePresenter
    SplashPresenter provideSplashPresenter() {
        return Injector.getPresenterComponent().getSplashPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onAttach();
    }


    @Override
    public void setupUI() {
        //do nothing, it's splash
    }

    @Override
    public void setupUX() {
        //do nothing, it's splash
    }

    @Override
    public void showRoomsActivity() {
        startActivity(ChatRoomsActivity.class);
        finish();
    }
}
