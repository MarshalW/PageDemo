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

    PageAnimationLayout pageAnimationLayout;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //动画视图的创建
        ViewGroup rootView = (ViewGroup) findViewById(R.id.rootView);//动画视图的容器
        View itemView = View.inflate(this, R.layout.item, rootView);//动画视图连带的布局
        pageAnimationLayout = (PageAnimationLayout) itemView.findViewById(R.id.targetViewGroup);//获取动画视图的布局对象
    }

    @Override
    protected void onResume() {
        super.onResume();
        //启动动画，延时1000ms，动画时长1000ms
        pageAnimationLayout.start(1000,1000);
    }
}
