package ru.alexbykov.chat.utils;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Alex Bykov on 15.02.2017.
 * You can contact me at: me@alexbykov.ru.
 */

public class RxUtils {

    private static final int DEFAULT_INTERVAL = 1;

    public static <T> ObservableTransformer<T, T> httpSchedulers() {
        return observable ->
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }


    public static Observable getPollingObservable(int repeatCount, OnPollingFinishedListener onPollingFinishedListener) {
        return Observable.interval(DEFAULT_INTERVAL, TimeUnit.SECONDS)
                .filter((AppendOnlyLinkedArrayList.NonThrowingPredicate<Long>) time -> isValid(repeatCount, time, onPollingFinishedListener))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                });
    }


    public static Observable getPollingObservable(int interval) {
        return Observable.interval(interval, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                });
    }




    private static boolean isValid(int repeatCount, Long time, OnPollingFinishedListener onPollingFinishedListener) {
        final boolean isValid = repeatCount - 1 >= time;
        if (!isValid) {
            onPollingFinishedListener.inFinish();
        }
        return isValid;
    }

    public static Observable delay(int roomUpdateDelay, OnPollingFinishedListener onPollingFinishedListener) {
        return getPollingObservable(roomUpdateDelay, onPollingFinishedListener);
    }


    public interface OnPollingFinishedListener {
        void inFinish();
    }
}
