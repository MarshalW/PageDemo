package com.example.pagedemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-2-19
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class PageAnimationView extends GLSurfaceView {
    //动画时长500ms
    private long duration = 1000;
    //延时2000ms执行
    private long startDelay = 2000;
    //动画定时对象
    private ValueAnimator animator;

    private CurlRenderer renderer;

    public PageAnimationView(Context context) {
        super(context);
        this.init();
    }

    public PageAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    private void init() {
        //使用OpenGL ES 2.0
        this.setEGLContextClientVersion(2);

        //设置透明背景
        this.setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        this.setZOrderOnTop(true);
        getHolder().setFormat(PixelFormat.TRANSPARENT);

        this.renderer = new CurlRenderer();
        this.setRenderer(this.renderer);

        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        this.renderer.setMargins(.5f, .4f, .05f, .2f);

        animator = ValueAnimator.ofFloat(1f,-1f);
        animator.setDuration(this.duration);
        animator.setStartDelay(startDelay);
        animator.setRepeatCount(10);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d("PageAnimation", "factor>>>>>" + valueAnimator.getAnimatedValue());
                renderer.setPositionFactor((Float)valueAnimator.getAnimatedValue());
                requestRender();
            }
        });
        animator.start();
    }
}
