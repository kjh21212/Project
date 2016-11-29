package com.example.hello.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/*
    강현규 작업
*/
public class TournamentStart extends AppCompatActivity {
    public static int[] img = {R.drawable.tour1, R.drawable.tour2, R.drawable.tour3, R.drawable.tour4, R.drawable.tour5, R.drawable.tour6, R.drawable.tour7, R.drawable.tour8, R.drawable.tour9
            , R.drawable.tour10, R.drawable.tour11, R.drawable.tour12, R.drawable.tour13, R.drawable.tour14, R.drawable.tour15, R.drawable.tour16, R.drawable.tour17, R.drawable.tour18, R.drawable.tour19
            , R.drawable.tour20, R.drawable.tour21, R.drawable.tour22, R.drawable.tour23, R.drawable.tour24, R.drawable.tour25, R.drawable.tour26, R.drawable.tour27, R.drawable.tour28, R.drawable.tour29
            , R.drawable.tour30, R.drawable.tour31, R.drawable.tour32, R.drawable.tour33, R.drawable.tour34, R.drawable.tour35, R.drawable.tour36, R.drawable.tour37, R.drawable.tour38, R.drawable.tour39
            , R.drawable.tour40, R.drawable.tour41, R.drawable.tour42, R.drawable.tour43, R.drawable.tour44, R.drawable.tour45, R.drawable.tour46, R.drawable.tour47, R.drawable.tour48
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