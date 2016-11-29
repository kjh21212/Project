package com.example.hello.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TournamentStart extends AppCompatActivity {
    public static int[] img = {R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4, R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8
            , R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12, R.drawable.logo13, R.drawable.logo14, R.drawable.logo15, R.drawable.logo16
    };
    public static int[] simg=shuffle(img);
    public static int num[] = new int[8];

    public static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_start);
        findViewById(R.id.backbutton99).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );

        findViewById(R.id.startbutton99).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Tournament.class);
                        startActivity(intent);
                    }
                }
        );
        count=0;
        simg=shuffle(simg);
        for(int i=0;i<num.length;i++){
            num[i]=simg[i];
        }
    }
    public static int[] shuffle(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;

        for (int x = 0; x < arr.length * 2; x++) {
            int i = (int) (Math.random() * arr.length);
            int j = (int) (Math.random() * arr.length);

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
}