package com.example.slidetouch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.example.easyslidetouch.EasySlideTouch;

public class MainActivity extends AppCompatActivity {

    private EasySlideTouch easySlideTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easySlideTouch = findViewById(R.id.easy_slide);

        easySlideTouch.setViewBackground(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background));

        easySlideTouch.setTextColor(ContextCompat.getColor(this, R.color.black));

//        easySlideTouch.setTextSize(14);

    }
}
