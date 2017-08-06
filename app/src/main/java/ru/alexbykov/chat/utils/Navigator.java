package ru.alexbykov.chat.utils;

import android.app.Activity;
import android.content.Intent;

import ru.alexbykov.chat.R;
import ru.alexbykov.chat.activities.base.BaseActivity;

/**
 * Date: 04.06.2017
 * Time: 10:00
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Navigator {


    //@formatter:off
    private Navigator(){}
    //@formatter:on

    public static void startActivity(Activity applicationContext,
                                     Class<? extends BaseActivity> activityClass,
                                     boolean clearBackStack) {
        Intent intent = new Intent(applicationContext, activityClass);
        if (clearBackStack) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        applicationContext.startActivity(intent);
        applicationContext.overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }


    public static void startActivityForResult(Activity activity,
                                              Class<? extends BaseActivity> activityClass,
                                              int requestCode) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }
}
