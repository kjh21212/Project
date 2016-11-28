package com.example.hello.project;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ask57 on 2016-11-27.
 */

public class wheelselect extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wheelselect);

        findViewById(R.id.backbutton2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 0);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 1);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button3).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 2);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button4).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 3);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button5).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 4);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button6).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 5);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button7).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 6);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.button8).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", 7);
                        startActivity(intent);
                    }
                }
        );
    }
}