package com.example.hello.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Tournament extends AppCompatActivity {
    int[] img = {R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4, R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8
            , R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12, R.drawable.logo13, R.drawable.logo14, R.drawable.logo15, R.drawable.logo16
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        TextView tv1 = (TextView)findViewById(R.id.tView1);
        TextView tv2 = (TextView)findViewById(R.id.tView2);
        findViewById(R.id.backbutton5).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.tView1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Tournament.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.tView2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Tournament.class);
                        startActivity(intent);
                    }
                }
        );

        Random ram1 = new Random();
        Random ram2 = new Random();
        //int[] num={};


        int num1 = ram1.nextInt(img.length);
        int num2 = ram2.nextInt(img.length);
        //num[1] = ram.nextInt(img.length);

        tv1.setBackgroundResource(img[num1]);
        tv2.setBackgroundResource(img[num2]);

    }
}