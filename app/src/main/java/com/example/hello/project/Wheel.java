package com.example.hello.project;
/*
    @author 안수길
    @2016.11.30
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Wheel extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private spintheWheel mLuckyWheel;
    protected Button mStartButton;
    protected static int item;
    private static String[] mItem = {"", "", "", "", "", "", "", ""};
    private Button[] add = new Button[6];
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);

        mLuckyWheel = (spintheWheel) findViewById(R.id.lucky_wheel);
        mStartButton = (Button) findViewById(R.id.start);
        mLuckyWheel.setVisibility(View.INVISIBLE);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mSpinner.setSelection(mLuckyWheel.mItemCount / 2 - 1);

        add[0] = (Button) findViewById(R.id.add0);   //돌림판에 아이템을 추가하기 위한 버튼들
        add[1] = (Button) findViewById(R.id.add1);
        add[2] = (Button) findViewById(R.id.add2);
        add[3] = (Button) findViewById(R.id.add3);
        add[4] = (Button) findViewById(R.id.add4);
        add[5] = (Button) findViewById(R.id.add5);
        for (int i = 0; i < 6; i++) {
            add[i].setEnabled(false);
        }
        //뒤로가기 버튼
        findViewById(R.id.backbutton2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );
        //돌리기 버튼
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check를 사용하여 모든 item이 선택되었는지 확인
                boolean check = true;
                for(int i=0;i<(item + 1) * 2;i++)
                {
                    if(add[i].getText().equals(""))
                    {
                        check = false;
                        break;
                    }
                    else
                        check=true;
                }
                if(check==false) {
                    Toast toast = Toast.makeText(Wheel.this, "나머지 모두 선택하세요.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{ //돌림판의 원이 돌아가고 있으면 멈추고 멈춰 있으면 돌아간다.
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
        //스피너를 통해 아이템의 총 수를 정하여 개수에 맞게 버튼 활성화 및 spintheWheel의 mItemCount변경
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mLuckyWheel.mItemCount = (mSpinner.getSelectedItemPosition() + 1) * 2;
                item = (mSpinner.getSelectedItemPosition());
                for (int i = 0; i < (item + 1) * 2; i++) {
                    add[i].setEnabled(true);
                }
                for (int i = (item + 1) * 2; i < 6; i++) {
                    add[i].setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //각각의 버튼 클릭시 index 4로 select class 실행하여 음식점을 추가한다.
        add[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                intent.putExtra("count", 4);
                startActivity(intent);
            }
        });
        add[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                intent.putExtra("count", 5);
                startActivity(intent);
            }
        });
        add[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                intent.putExtra("count", 6);
                startActivity(intent);
            }
        });
        add[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                intent.putExtra("count", 7);
                startActivity(intent);
            }
        });
        add[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                intent.putExtra("count", 8);
                startActivity(intent);
            }
        });
        add[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                intent.putExtra("count", 9);
                startActivity(intent);
            }
        });
        //intent로 들어온 select1을 사용하여 아이템의 이름을 설정한다.
        for (int j = 0; j < (item + 1) * 2; j++) {
            Intent intent = getIntent();
            final int count = intent.getIntExtra("i", j + 4);
            mItem[count - 4] = intent.getStringExtra("select1");
        }
        for (int j = 0; j < (item + 1) * 2; j++) {
            add[j].setText(mItem[j]);
            mLuckyWheel.mTexts[j] = mItem[j];
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
