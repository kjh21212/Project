package com.example.hello.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Tournament extends AppCompatActivity {
    int[] img = {R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4, R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8
            , R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12, R.drawable.logo13, R.drawable.logo14, R.drawable.logo15, R.drawable.logo16
    };
    int[] suffle = shuffle(img);

    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tournament);

        Random ram = new Random();

        int num1 = ram.nextInt(img.length);
        int num2 = ram.nextInt(img.length);


        final TextView tv1 = (TextView)findViewById(R.id.tView1);
        final TextView tv2 = (TextView)findViewById(R.id.tView2);
        tv1.setBackgroundResource(img[i]);
        tv2.setBackgroundResource(img[i+1]);

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
                        i=i+2;
                        tv1.setBackgroundResource(img[i]);
                    }
                }
        );
        findViewById(R.id.tView2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        i=i+2;
                        tv2.setBackgroundResource(img[i+1]);
                    }
                }
        );
        tv1.setBackgroundResource(img[num1]);
        tv2.setBackgroundResource(img[num2]);

    }
    public static int[] shuffle(int[] arr) {
        if(arr==null || arr.length==0)
            return arr;

        for(int x=0; x<arr.length*2;x++) {
            int i = (int)(Math.random()*arr.length);
            int j = (int)(Math.random()*arr.length);

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
}
