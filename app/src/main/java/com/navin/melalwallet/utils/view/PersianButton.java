package com.navin.melalwallet.utils.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

public class PersianButton extends AppCompatButton {

    public PersianButton(Context context) {
        super(context);
        setFont(context);
    }

    public PersianButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public PersianButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/IRANSans_Bold.ttf");
        setTypeface(typeface);
    }
}
