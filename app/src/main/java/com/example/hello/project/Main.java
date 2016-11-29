package com.example.hello.project;
/*
 16.11.28 재커밋
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    public static boolean bFirst = true;
    static {
        System.loadLibrary("native-lib");
    }

    AppCompatActivity act = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TournamentStart.count=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(bFirst == true) {
            startActivity(new Intent(this, Loding.class)); // Loding Class
            bFirst = false;
        }
        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Restaurant.class);
                        startActivity(intent);
                    }
                }
        );

        findViewById(R.id.button2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Ladder.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button3).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Wheel.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button4).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Category.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button5).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), TournamentStart.class);
                        startActivity(intent);
                    }
                }
        );

    }

    public native String stringFromJNI();
}
