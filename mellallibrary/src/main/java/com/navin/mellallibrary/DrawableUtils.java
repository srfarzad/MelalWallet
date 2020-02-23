package com.navin.mellallibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import androidx.core.graphics.drawable.DrawableCompat;


/**
 * Created by farzad.sarseify on 14/03/2017.
 */

public class DrawableUtils {

    public static Drawable changeDrawableColor(int drawableRes, int colorRes, Context context) {
        //Convert drawable res to bitmap
        final Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawableRes);
        final Bitmap resultBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth() - 1, bitmap.getHeight() - 1);
        final Paint p = new Paint();
        final Canvas canvas = new Canvas(resultBitmap);
        canvas.drawBitmap(resultBitmap, 0, 0, p);

        //Create new drawable based on bitmap
        final Drawable drawable = new BitmapDrawable(context.getResources(), resultBitmap);
        drawable.setColorFilter(new
                PorterDuffColorFilter(context.getResources().getColor(colorRes), PorterDuff.Mode.MULTIPLY));
        return drawable;
    }

    public static Drawable setTint(Drawable d, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(d);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }


    public static void customView(Context context,View v, int backgroundColor, int borderColor)
    {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(backgroundColor);
        shape.setStroke(1, borderColor);
        v.setBackground(shape);
    }

    public static void customCicleView(Context context,View v, int backgroundColor, int borderColor)
    {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setCornerRadii(new float[] { 0, 0, 8, 8, 0, 0, 0, 0 });
        shape.setColor(context.getResources().getColor(R.color.white));
        shape.setStroke(5, borderColor);
        v.setBackgroundDrawable(shape);
    }



    public static void CircleView(Context context,View v, int backgroundColor, int borderColor)
    {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setCornerRadii(new float[] { backgroundColor, backgroundColor, backgroundColor, backgroundColor, backgroundColor, backgroundColor, backgroundColor, backgroundColor});
        shape.setColor(backgroundColor);
        shape.setStroke(1, borderColor);
        v.setBackgroundDrawable(shape);
    }



    public static Drawable generateShape(int colorTop) {
        int top, bot, stroke;
        top = colorTop;
        bot = colorTop;
        stroke = Color.parseColor("#ffffff");

        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{top, bot});
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setStroke(1, stroke);
        drawable.setCornerRadius(10);

        return drawable;
    }






}
