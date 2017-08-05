package ru.alexbykov.chat.custom.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import ru.alexbykov.chat.R;


/**
 * Created by Alex Bykov on 28.03.2017.
 * You can contact me at: me@alexbykov.ru.
 * <p>
 * Используется
 */

public class BadgeView extends FrameLayout {


    private TextView badgeText;

    private static final int MAX_COUNT = 99;
    private static final String MORE_THAN_MAX = "99+";

    private int horizontalMargin;
    private int verticalMiddleMargin;
    private int verticalSmallMargin;

    public BadgeView(Context context) {
        super(context);
    }

    public BadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupBadge();
    }

    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupBadge();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void setupBadge() {
        bindDimens();
        badgeText = new TextView(getContext());
        badgeText.setPadding(horizontalMargin, 0, horizontalMargin, 0);
        badgeText.setTextSize(getDimen(R.dimen.badge_normal_text_size));
        badgeText.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        badgeText.setGravity(Gravity.CENTER | Gravity.BOTTOM);

        setShapeColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        addView(badgeText);
    }

    private void bindDimens() {
        horizontalMargin = getDimen(R.dimen.badge_horizontal_margin);
        verticalSmallMargin = getDimen(R.dimen.slim_size);
        verticalMiddleMargin = getDimen(R.dimen.badge_very_small_margin);
    }

    public void setCount(int count) {
        setVisibilityByCount(count);

        if (count > MAX_COUNT) {
            threeNumberSettings();
            badgeText.setText(MORE_THAN_MAX);
        } else {
            standartSettings();
            badgeText.setText(String.valueOf(count));
        }
    }

    private void setVisibilityByCount(int count) {
        setVisibility(count == 0 ? INVISIBLE : VISIBLE);
    }

    private void threeNumberSettings() {
        badgeText.setPadding(horizontalMargin, verticalMiddleMargin, horizontalMargin, verticalMiddleMargin);
    }

    private void standartSettings() {
        badgeText.setPadding(horizontalMargin, verticalSmallMargin, horizontalMargin, verticalSmallMargin);
    }

    @SuppressLint("SupportAnnotationUsage")
    @ColorRes
    public void setShapeColor(int colorId) {
        create(this, colorId);
    }

    @SuppressLint("SupportAnnotationUsage")
    @ColorRes
    public void setTextColor(int colorId) {
        badgeText.setTextColor(ContextCompat.getColor(getContext(), colorId));
    }


    private void create(View view, int backgroundColor) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setCornerRadius(getDimen(R.dimen.badge_size));
        shape.setColor(backgroundColor);
        view.setBackground(shape);
    }

    public int getDimen(@DimenRes int dimenRes) {
        return (int) getContext().getResources().getDimension(dimenRes);
    }


}
