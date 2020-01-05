package com.navin.melalwallet.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
        setFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/BHoma.ttf");
        setTypeface(typeface);
    }
}
