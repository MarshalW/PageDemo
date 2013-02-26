package com.example.pagedemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static android.view.View.*;

public class MyActivity extends Activity {

    PageAnimationView pageAnimationView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View view = findViewById(R.id.targetView);
        view.buildDrawingCache();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        view.buildDrawingCache();

        pageAnimationView = new PageAnimationView(this);
        Bitmap bitmap=loadBitmapFromView(view);
        pageAnimationView.setBitmap(bitmap);
//        saveBitmap(bitmap,"hello.png");
        viewGroup.addView(pageAnimationView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pageAnimationView.start();
    }

    public static Bitmap loadBitmapFromView(View v) {
        View p = (View) v.getParent();
        Bitmap b = Bitmap.createBitmap(p.getLayoutParams().width, p.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.measure(
                MeasureSpec.makeMeasureSpec(p.getLayoutParams().width,MeasureSpec.EXACTLY),
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
}
