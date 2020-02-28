package com.example.easyslidetouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class EasySlideTouch extends ConstraintLayout {

    private MutableLiveData<Integer> count;

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

        count = new MutableLiveData<>();
        count.setValue(0);
        count.observeForever(dd);

//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SlideTouch,
//                0, 0);

    }

    private Observer<Integer> dd = new Observer<Integer>() {
        @Override
        public void onChanged(Integer integer) {
            Log.i("###log", "retre" + count.getValue());
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        count.setValue(count.getValue() + 1);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                return true;
            case MotionEvent.ACTION_MOVE:

                return true;
            case MotionEvent.ACTION_UP:

                if (ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_LTR) {
                    Integer i = count.getValue();
                    i += 1;
                    count.setValue(i);
                } else {
                    Integer i = count.getValue();
                    i--;
                    count.setValue(i);
                }
                return true;


            default:
                return false;
        }

//        return super.onTouchEvent(event);
    }


}
