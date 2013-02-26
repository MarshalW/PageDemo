package com.example.pagedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-2-26
 * Time: 下午5:35
 * To change this template use File | Settings | File Templates.
 */
public class MyButton extends Button implements PageAnimationLayout.AnimationEndCallback {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void callback() {
        Toast.makeText(this.getContext(), "动画结束后的做...",
                Toast.LENGTH_SHORT).show();
    }
}
