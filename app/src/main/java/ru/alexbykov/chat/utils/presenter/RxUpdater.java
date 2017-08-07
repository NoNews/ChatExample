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
    private Disposable chatDelay;
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
                .compose(RxUtils.httpSchedulers())
                .doOnSubscribe(v -> updateListener.onUpdate(Const.Update.CHAT_START))
                .doOnNext(v -> onUpdate(Const.Update.CHAT_UPDATE))
                .subscribe();
    }


    @SuppressWarnings("unchecked")
    public void startRoomUpdate() {
        roomUpdate = RxUtils.getPollingObservable(ROOM_UPDATE_INTERVAL)
                .compose(RxUtils.httpSchedulers())
                .doOnNext(v -> updateListener.onUpdate(Const.Update.ROOM_UPDATE))
                .subscribe();
    }


    @SuppressWarnings("unchecked")
    private void startChatDelay() {
        disposeChatUpdate();
        chatDelay = RxUtils.delay(CHAT_UPDATE_DELAY, this::startChatUpdate)
                .compose(RxUtils.httpSchedulers())
                .doOnSubscribe(v -> updateListener.onUpdate(Const.Update.DELAY_START))
                .subscribe();
    }

    private void disposeChatUpdate() {
        if (chatUpdate != null)
            chatUpdate.dispose();
    }

    private void disposeDelay() {
        if (chatDelay != null) {
            chatDelay.dispose();
        }
    }

    private void onUpdate(Const.Update update) {
        updateListener.onUpdate(update);
        Log.i(TAG, "onUpdate: messageeeeeeeeeee" + ++count);
    }

    public void disposeRoom() {
        roomUpdate.dispose();
    }

    public void disposeChat() {
        if (chatUpdate != null) chatUpdate.dispose();
        if (chatDelay != null) chatDelay.dispose();
    }
}
