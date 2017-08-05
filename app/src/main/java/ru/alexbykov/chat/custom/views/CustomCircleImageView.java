package ru.alexbykov.chat.custom.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.alexbykov.chat.utils.ImageLoader;

/**
 * Date: 05.08.2017
 * Time: 18:49
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class CustomCircleImageView extends CircleImageView {

    public CustomCircleImageView(Context context) {
        super(context);
    }

    public CustomCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public final void load(@NonNull String URL) {
        ImageLoader.load(getContext(), this, URL);
    }
}
