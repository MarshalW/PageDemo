package com.example.pagedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-2-21
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class PageAnimationLayout extends FrameLayout {

    private View targetView;

    public PageAnimationLayout(Context context) {
        super(context);
        this.init();
    }

    public PageAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public PageAnimationLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        int childLeft = 0;
//        final int childCount = getChildCount();
//
////        for (int i=0; i<childCount; i++) {
////            final View childView = getChildAt(i);
////            if (childView.getVisibility() != View.GONE) {
////                final int childWidth = childView.getMeasuredWidth();
////                childView.layout(childLeft, 0,
////                        childLeft+childWidth, childView.getMeasuredHeight());
////                childLeft += childWidth;
////            }
////        }
//
//        View childView = getChildAt(0);
//
//        if (childView.getVisibility() != View.GONE) {
//                final int childWidth = childView.getMeasuredWidth();
//                childView.layout(childLeft, 0,
//                        childLeft+childWidth, childView.getMeasuredHeight());
//                childLeft += childWidth;
//            }
//    }

    private void init() {
        //TODO 加入初始化内容
    }

    private View getTargetView() {
        if (this.targetView == null) {
            for (int i = 0; i < this.getChildCount(); i++) {
                if (this.getChildAt(i) instanceof AnimationEndCallback) {
                    this.targetView = this.getChildAt(i);
                }
            }
            if (this.targetView == null) {
                throw new RuntimeException("error: not found inner view!");
            }
        }
        return this.targetView;
    }
}

interface AnimationEndCallback {
    void callback();
}
