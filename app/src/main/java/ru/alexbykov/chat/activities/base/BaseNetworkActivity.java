package ru.alexbykov.chat.activities.base;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ru.alexbykov.chat.interfaces.utils_view.NetworkView;

/**
 * Date: 04.06.2017
 * Time: 12:17
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class BaseNetworkActivity extends BaseActivity implements NetworkView {


    protected ViewGroup ltData;
    protected ProgressBar progressBar;
    protected Button btnRepeat;
    protected ViewGroup ltError;
    protected TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) showView(progressBar);
        else hideView(progressBar);
    }

    @Override
    public void showData(boolean show) {
        if (show) showView(ltData);
        else hideView(ltData);
    }

    @Override
    public void showNetworkError(boolean show) {
        if (show) {
            showView(ltError);
        } else hideView(ltError);
    }
}
