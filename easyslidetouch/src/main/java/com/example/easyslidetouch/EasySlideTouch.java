package com.example.easyslidetouch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.constraintlayout.widget.ConstraintLayout;

public class EasySlideTouch extends ConstraintLayout {

    public EasySlideTouch(Context context) {
        super(context);
    }

    public EasySlideTouch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EasySlideTouch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.slide_touch, this, true);

//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SlideTouch,
//                0, 0);

    }


}
