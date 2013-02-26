package com.example.pagedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-2-21
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class PageAnimationLayout extends FrameLayout {

    boolean started;

    public PageAnimationLayout(Context context) {
        super(context);
    }

    public PageAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PageAnimationLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void start(long startDelay,long duration) {
        if(!started){
            View targetView = findViewById(R.id.targetView);
            targetView.buildDrawingCache();
            targetView.buildDrawingCache();

            PageAnimationView animationView = new PageAnimationView(this.getContext());
            animationView.setStartDelay(startDelay);
            animationView.setDuration(duration);

            Bitmap bitmap=loadBitmapFromView(targetView);
            animationView.setBitmap(bitmap);
            this.addView(animationView);

            if(targetView instanceof AnimationEndCallback){
                animationView.setAnimationEndCallback((AnimationEndCallback)targetView);
            }

            animationView.start();
            this.started=true;
        }

    }

    public static Bitmap loadBitmapFromView(View v) {
        View p = (View) v.getParent();
        Bitmap b = Bitmap.createBitmap(p.getLayoutParams().width, p.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.measure(
                MeasureSpec.makeMeasureSpec(p.getLayoutParams().width, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(p.getLayoutParams().height, MeasureSpec.EXACTLY));
        v.layout(0, 0, p.getLayoutParams().width, p.getLayoutParams().height);
        v.draw(c);
        return b;
    }


    public static void saveBitmap(Bitmap bitmap, String fileName) {
        String filePath = Environment.getExternalStorageDirectory() + "/" + fileName;
        try {
            OutputStream stream = new FileOutputStream(filePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, stream);
            stream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public interface AnimationEndCallback {
        void callback();
    }
}


