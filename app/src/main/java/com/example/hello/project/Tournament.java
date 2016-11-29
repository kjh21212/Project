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
            , R.drawable.logo9, R.drawable.logo10};
    int[] suffle = shuffle(img);
    int[] result8 = new int[8];
    int[] result4 = new int[4];
    int[] result2 = new int[2];

    int i = 0;
    int j = 0;
    int a = 0;
    int b = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tournament);

        Random ram = new Random();

        int num1 = ram.nextInt(img.length);
        int num2 = ram.nextInt(img.length);

        final TextView tv1 = (TextView) findViewById(R.id.tView1);
        final TextView tv2 = (TextView) findViewById(R.id.tView2);
        final TextView how = (TextView) findViewById(R.id.howmany);

        findViewById(R.id.backbutton5).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );

        how.setText("16강");
        tv1.setBackgroundResource(suffle[i]);
        tv2.setBackgroundResource(suffle[i + 1]);

        findViewById(R.id.tView1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (i <= 13) {
                            result8[j] = suffle[i];
                            j++;
                            i = i + 2;
                            tv1.setBackgroundResource(suffle[i]);
                            tv2.setBackgroundResource(suffle[i + 1]);
                        }
                        else {
                            how.setText("8강");
                            tv1.setBackgroundResource(result8[a]);
                            tv2.setBackgroundResource(result8[a + 1]);
                            result4[b] = result8[a];
                            if(a<=7){
                                a = a + 2;
                            }
                            b++;
                        }
                    }
                }
        );
        findViewById(R.id.tView2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (i <= 13) {
                            result8[j] = suffle[i];
                            j++;
                            i = i + 2;
                            tv1.setBackgroundResource(suffle[i]);
                            tv2.setBackgroundResource(suffle[i + 1]);
                        }
                        else {
                            how.setText("8강");
                            tv1.setBackgroundResource(result8[a]);
                            tv2.setBackgroundResource(result8[a + 1]);
                            result4[b] = result8[a + 1];
                            if(a<=7){
                                a = a + 2;
                            }
                            b++;
                        }
                    }
                }
        );


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
