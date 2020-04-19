package com.example.slidetouch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.easyslidetouch.EasySlideTouch;
import com.example.easyslidetouch.OnSlideChangeListener;

public class MainActivity extends AppCompatActivity implements OnSlideChangeListener {

    private EasySlideTouch easySlideTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easySlideTouch = findViewById(R.id.easy_slide);

        easySlideTouch.setViewBackground(ContextCompat.getDrawable(this, R.drawable.round_corner_yellow));

        easySlideTouch.setTextColor(ContextCompat.getColorStateList(this, R.color.selector_text_color));

//        easySlideTouch.setTextSize(14);

//        easySlideTouch.setEnableSlide(false);

        easySlideTouch.setViewBackgroundDisable(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background));

        easySlideTouch.setOnSlideChangeListener(this);

    }


    @Override
    public void OnSlideChange(int value) {
        Toast.makeText(this, value + "", Toast.LENGTH_SHORT).show();
    }
}
