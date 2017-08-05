package ru.alexbykov.chat.utils.presenter;

import android.util.Log;

import io.reactivex.disposables.Disposable;
import ru.alexbykov.chat.Const;
import ru.alexbykov.chat.interfaces.callbacks.updater.UpdateListener;
import ru.alexbykov.chat.utils.RxUtils;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Date: 04.08.2017
 * Time: 23:23
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class RxUpdater {

    private static final int CHAT_UPDATE_TIME = 60;
    private static final int CHAT_UPDATE_DELAY = 20;
    private static final int ROOM_UPDATE_INTERVAL = 3;

    private Disposable chatUpdate;
    private Disposable roomDelay;
    private Disposable roomUpdate;
    private int count;
    private UpdateListener updateListener;

    public RxUpdater(UpdateListener updateListener) {
        this.updateListener = updateListener;
    }


    @SuppressWarnings("unchecked")
    public void startChatUpdate() {
        disposeDelay();
        chatUpdate = RxUtils.getPollingObservable(CHAT_UPDATE_TIME, this::startChatDelay)
                .doOnNext(v -> onUpdate(Const.Update.CHAT))
                .subscribe();
    }


    @SuppressWarnings("unchecked")
    public void startRoomUpdate() {
        roomUpdate = RxUtils.getPollingObservable(ROOM_UPDATE_INTERVAL)
                .doOnNext(v -> updateListener.onUpdate(Const.Update.ROOM))
                .subscribe();
    }


    private void startChatDelay() {
        disposeChatUpdate();
        roomDelay = RxUtils.delay(CHAT_UPDATE_DELAY, this::startRoomUpdate).subscribe();
    }

    private void disposeChatUpdate() {
        if (chatUpdate != null)
            chatUpdate.dispose();
    }

    private void disposeDelay() {
        if (roomDelay != null) {
            roomDelay.dispose();
        }
    }

    private void onUpdate(Const.Update update) {
        updateListener.onUpdate(update);
        Log.i(TAG, "onUpdate: messageeeeeeeeeee" + ++count);
    }

    public void unsubscribe() {
        roomUpdate.dispose();
    }
}
