package com.example.hello.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Wheel extends AppCompatActivity {
    private spintheWheel mLuckyWheel; //Surfaceview에 돌림판을 보여주기위해
    protected Button mStartButton; //돌리기 버튼 클릭시 돌림판이 start
    private Button countbutton; //돌림판 내의 item개수를 변경하기 위한 버튼
    private EditText countEdit; //돌림판 내의 item개수를 변경하기 위해 입력하는 수를 받아온다
    private Button mAdditem;
    protected static int item;
    private String[] mItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);
        mLuckyWheel = (spintheWheel) findViewById(R.id.lucky_wheel);
        mStartButton = (Button) findViewById(R.id.start);
        mLuckyWheel.setVisibility(View.INVISIBLE);
        countbutton = (Button) findViewById(R.id.button);
        countEdit = (EditText) findViewById(R.id.editText);
        mAdditem = (Button) findViewById(R.id.additem);

        countbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLuckyWheel.mItemCount = Integer.parseInt(countEdit.getText().toString());
                item = Integer.parseInt(countEdit.getText().toString());
                mItem = new String[item];
            }

        });

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item == 0) {

                } else {
                    if (mLuckyWheel.isStarting()) {
                        if (!mLuckyWheel.isShouldStop()) {
                            mLuckyWheel.stop();
                            mStartButton.setText("돌리기");
                        }
                    } else {

                        mLuckyWheel.setVisibility(View.VISIBLE);
                        mLuckyWheel.start(0);
                        mStartButton.setText("멈추기");
                    }
                }
            }
        });

        mAdditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 4;
                if (item == 0) {

                } else {
                    while(i>=item) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        intent.putExtra("count", i);
                        startActivity(intent);
                        i++;
                    }
                }
            }
        });
        Intent intent = getIntent();
      /*  for (int j = 0; j < item; j++) {
            final int count = intent.getIntExtra("i", j + 4);
            mItem[count - 4] = intent.getStringExtra("select1");
        }
       for(int j = 0; j < item; j++){
            mLuckyWheel.mTexts[j]=mItem[j];
        }*/

    }
}
