package com.example.hello.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Wheel extends AppCompatActivity {
    private spintheWheel mLuckyWheel;
    private ImageButton mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);



        mLuckyWheel = (spintheWheel) findViewById(R.id.lucky_wheel);
        mStartButton = (ImageButton) findViewById(R.id.start);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLuckyWheel.isStarting()) {
                    if (!mLuckyWheel.isShouldStop()) {
                        mLuckyWheel.stop();
                        mStartButton.setBackgroundResource(R.drawable.start);
                    }
                } else {
                    mLuckyWheel.start(0);
                    mStartButton.setBackgroundResource(R.drawable.start);
                }
            }
        });


    }
}
