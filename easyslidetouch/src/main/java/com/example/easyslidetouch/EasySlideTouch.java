package com.example.easyslidetouch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class EasySlideTouch extends ConstraintLayout {

    private MutableLiveData<Integer> count;
    private TextView counterTv;
    private FrameLayout counterFl;
    private Float start = 0F;
    private ConstraintLayout viewBackgroundCl;

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

        counterTv = findViewById(R.id.viewCounterText);
        counterFl= findViewById(R.id.viewCounter);
        viewBackgroundCl= findViewById(R.id.viewBackground);

        count = new MutableLiveData<>();
        count.setValue(0);
        count.observeForever(dd);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EasySlideTouch,
                    0, 0);

            int drawableBackground = typedArray.getResourceId(R.styleable.EasySlideTouch_slideBackgroundColor, R.color.slide_background);
            viewBackgroundCl.setBackground(ContextCompat.getDrawable(context, drawableBackground));

            typedArray.recycle();
        }
    }

    private Observer<Integer> dd = new Observer<Integer>() {
        @Override
        public void onChanged(Integer value) {
            Log.i("###log", "retre" + value);
            counterTv.setText(value + "");
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                start = event.getX();
                return true;
            case MotionEvent.ACTION_MOVE:
                counterFl.setTranslationX(event.getX() - start);
                return true;
            case MotionEvent.ACTION_UP:
                if (counterFl.getTranslationX() > counterFl.getWidth() * 0.5) {
                    if (getIsLtr()) {
                        add();
                    } else {
                        subtract();
                    }
                } else if (counterFl.getTranslationX() < -(counterFl.getWidth() * 0.5)) {
                    if (getIsLtr()) {
                        subtract();
                    } else {
                        add();
                    }
                }

                if (counterFl.getTranslationX() != 0f) {
                    counterFl.setTranslationX(0f);
                }
                return true;
            default:
                return false;
        }

//        return super.onTouchEvent(event);
    }

    private void add() {
        Integer i = count.getValue();
        i += 1;
        count.setValue(i);
    }

    private void subtract() {
        Integer i = count.getValue();
        i -= 1;
        count.setValue(i);
    }

    private boolean getIsLtr () {
        return ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_LTR;
    }
}
