package com.example.pagedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-2-21
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public class MyTextView extends TextView implements AnimationEndCallback{
    public MyTextView(Context context) {
        super(context);
        this.init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    private void init(){
//        this.setDrawingCacheEnabled(true);
    }

    @Override
    public void callback() {
        //TODO 加入比如执行进一步动画
    }
}
