package ru.alexbykov.chat.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.interfaces.utils_view.BaseLifeCycle;
import ru.alexbykov.chat.interfaces.utils_view.NavigatorActivityView;
import ru.alexbykov.chat.utils.AnimationHelper;
import ru.alexbykov.chat.utils.Injector;
import ru.alexbykov.chat.utils.KeyboardHelper;
import ru.alexbykov.chat.utils.Navigator;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public abstract class BaseActivity extends MvpAppCompatActivity implements NavigatorActivityView, BaseLifeCycle {

    protected final String TAG = getClass().getSimpleName();

    protected Toolbar toolbar;

    @Inject
    protected AnimationHelper animationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Injector.getViewComponent().inject(this);
        setupUI(); //Дополнительный этап жизненного цикла — bindViews
        setupUX(); //Дополнительный этап жизненного цикла — Listeners
    }


    protected final void hideKeyboard() {
        KeyboardHelper.hide(this);
    }

    protected final void hideView(@NonNull View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
        }
    }

    protected final void showView(@NonNull View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public final void startActivity(Class<? extends BaseActivity> activityClass) {
        Navigator.startActivity(this, activityClass, false);
        overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
    }

    @Override
    public final void startActivityForResult(Class<? extends BaseActivity> activityClass, int requestCode) {
        Navigator.startActivityForResult(this, activityClass, requestCode);
        overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
    }

    @Override
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }


    @SuppressWarnings("unchecked")
    protected final <T extends View> T bindView(@IdRes int id) {
        return (T) findViewById(id);
    }


    @SuppressWarnings("unchecked")
    protected final int bindColor(@ColorRes int id) {
        return ContextCompat.getColor(this, id);
    }


    @SuppressWarnings("unchecked")
    protected final String bindString(@StringRes int id) {
        return getString(id);
    }

    @SuppressWarnings("unchecked")
    protected final int bindDimen(@DimenRes int id) {
        return (int) getResources().getDimension(id);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }


}
