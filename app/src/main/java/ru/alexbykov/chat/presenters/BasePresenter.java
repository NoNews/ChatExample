package ru.alexbykov.chat.presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.alexbykov.chat.api.RestApi;
import ru.alexbykov.chat.cache.ChatManager;
import ru.alexbykov.chat.utils.presenter.Resources;
import ru.alexbykov.chat.utils.presenter.TokenHelper;
import ru.alexbykov.chat.utils.presenter.chat.ChatHelper;
import ru.alexbykov.chat.utils.presenter.chat.RoomsHelper;
import ru.alexbykov.novalid.Validator;


/**
 * Created by Alex Bykov on 15.02.2017.
 * You can contact me at: me@alexbykov.ru.
 */

public class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    protected RestApi restApi;
    protected TokenHelper tokenHelper;
    protected RoomsHelper roomsHelper;
    protected ChatManager chatManager;
    protected ChatHelper chatHelper;
    protected Resources resources;
    protected Validator validator;
    //
    protected final String TAG = getClass().getSimpleName();


    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Deprecated
    protected final void startBus() {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Deprecated
    protected final void stopBus() {
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }

    protected final void unSubscribeOnDestroy(@NonNull Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
        if (roomsHelper!=null){
            roomsHelper.unsubscribe();
        }
        if(chatHelper!=null){
            chatHelper.unsubscribe();
        }
    }
}
