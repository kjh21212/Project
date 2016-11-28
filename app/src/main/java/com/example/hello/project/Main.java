package com.example.hello.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class Main extends AppCompatActivity {

    public static boolean bFirst = true;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    AppCompatActivity act = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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
                        Intent intent = new Intent(getApplicationContext(), Tournament.class);
                        startActivity(intent);
                    }
                }
        );

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
