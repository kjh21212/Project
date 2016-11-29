package com.example.hello.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.*;
import android.widget.TextView;
import java.util.*;

public class Category extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView tv;
    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10;
    ArrayList al = new ArrayList(); // 다량의 데이터를 담을 객체

    // 음식점이름, 밥(1), 면(2), 국물(3), 매움(4), 육류(5), 해물(6,) 간식(7), 야식(8), 중식(9), 일식(10)
    final String[] Check = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};

    String[][] name = {
           /*01*/ {"구공탄", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*02*/ {"눈물닭발", "0", "0", "0", "1", "1", "0", "0", "0", "0", "0"},
           /*03*/ {"땡초불닭발", "0", "0", "0", "1", "1", "0", "0", "0", "0", "0"},
           /*04*/ {"마산아구찜", "1", "0", "0", "1", "0", "1", "0", "0", "0", "0"},
           /*05*/ {"명인찜닭", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*06*/ {"미가도시락", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
           /*07*/ {"박가네부대전골", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0"},
           /*08*/ {"볶음세상", "1", "0", "0", "1", "1", "1", "0", "1", "0", "0"},
           /*09*/ {"뿔난돼지신곱창", "0", "0", "0", "1", "1", "0", "0", "1", "0", "0"},
           /*10*/ {"수상한불닭발", "0", "0", "0", "1", "1", "0", "0", "1", "0", "0"},
           /*11*/ {"신화불골뱅이", "0", "0", "0", "1", "0", "1", "0", "1", "0", "0"},
           /*12*/ {"안동촌찜닭", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*13*/ {"어가해물찜", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*14*/ {"흥보네안동찜닭", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*15*/ {"영월쌈밥", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*16*/ {"의정부부대찌개", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0"},
           /*17*/ {"원할매보쌈족발", "0", "0", "0", "1", "1", "0", "0", "1", "0", "0"},
           /*18*/ {"장충동가마솥왕족발", "0", "0", "0", "1", "1", "0", "0", "1", "0", "0"},
           /*19*/ {"장충동한양왕족발", "0", "0", "0", "1", "1", "0", "0", "1", "0", "0"},
           /*20*/ {"참조은웰빙쌈밥", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*21*/ {"추풍령할매감자탕", "1", "0", "1", "0", "1", "0", "0", "0", "0", "0"},
           /*22*/ {"한솥명가갈비찜", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0"},
           /*23*/ {"남경", "1", "1", "1", "0", "1", "1", "0", "0", "1", "0"},
           /*24*/ {"동국반점", "1", "1", "1", "0", "1", "1", "0", "0", "1", "0"},
           /*25*/ {"사해루", "1", "1", "1", "0", "1", "1", "0", "0", "1", "0"},
           /*26*/ {"아리산", "1", "1", "1", "0", "1", "1", "0", "0", "1", "0"},
           /*27*/ {"미스터돈가스", "1", "1", "1", "0", "1", "0", "0", "0", "0", "1"},
           /*28*/ {"59쌀피자", "0", "0", "0", "0", "0", "0", "1", "1", "0", "0"},
           /*29*/ {"교촌치킨", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*30*/ {"깐부치킨", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*31*/ {"네네치킨", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*32*/ {"몬테피자", "0", "1", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*33*/ {"미스터피자", "0", "0", "0", "0", "0", "0", "1", "1", "0", "0"},
           /*34*/ {"미쳐버린파닭", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*35*/ {"위대한치킨24시", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*36*/ {"치킨의전설", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*37*/ {"파파이스", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*38*/ {"피막치골", "0", "1", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*39*/ {"피자나라치킨공주", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*40*/ {"ICG", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0"},
           /*41*/ {"김가네", "1", "1", "1", "1", "1", "1", "1", "0", "0", "1"},
           /*42*/ {"나래분식", "1", "1", "1", "1", "1", "1", "1", "0", "0", "1"},
           /*43*/ {"신당동해물떡볶이", "0", "0", "0", "1", "0", "1", "1", "1", "0", "0"},
           /*44*/ {"동대문엽기떡볶이", "0", "0", "0", "1", "0", "0", "1", "1", "0", "0"},
           /*45*/ {"용우동", "1", "1", "1", "1", "1", "1", "1", "0", "0", "1"},
           /*46*/ {"윤떡", "0", "0", "0", "1", "0", "0", "1", "1", "0", "0"},
           /*47*/ {"진아네떡볶이", "0", "0", "0", "1", "0", "0", "1", "1", "0", "0"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb6 = (CheckBox) findViewById(R.id.checkBox6);
        cb7 = (CheckBox) findViewById(R.id.checkBox7);
        cb8 = (CheckBox) findViewById(R.id.checkBox8);
        cb9 = (CheckBox) findViewById(R.id.checkBox9);

        cb10 = (CheckBox) findViewById(R.id.checkBox10);
        tv = (TextView) findViewById(R.id.c_TextView);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);
        cb6.setOnCheckedChangeListener(this);
        cb7.setOnCheckedChangeListener(this);
        cb8.setOnCheckedChangeListener(this);
        cb9.setOnCheckedChangeListener(this);
        cb10.setOnCheckedChangeListener(this);

        final String[] result2 = {""};

        findViewById(R.id.backbutton4).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );

        findViewById(R.id.setcheck).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        al.clear();

                        int [] k = new int[10];
                        int b=0;
                        for(int i=1; i<11; i++)
                        {
                            if(Check[i].equals("1")) {
                                k[b] = i;
                                b++;
                            }
                        }
                        result2[0] = "";
                        for (int i = 0; i < 47; i++) {
                            for (int j = 0; j < b; j++) {
                                if (name[i][k[j]].equals("1") && name[i][k[j+1]].equals("1")){
                                    al.add(name[i][0]);
                                }
                            }
                        }
                        MyAdapter adapter = new MyAdapter (
                                getApplicationContext(), // 현재 화면의 제어권자
                                R.layout.row, // xml 에 작성한 array 항목을 지정
                                al);
                        ListView lv = (ListView) findViewById(R.id.listview);
                        lv.setAdapter(adapter);
                    }


                }
        );


    }
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String result = ""; // 문자열 초기화는 빈 문자열

        if (cb1.isChecked()) {
            result += cb1.getText().toString() + ", ";
            Check[1] = "1";
        } else {
            Check[1] = "0";
        }

        if (cb2.isChecked()) {
            result += cb2.getText().toString() + ", ";
            Check[2] = "1";
        } else {
            Check[2] = "0";
        }

        if (cb3.isChecked()) {
            result += cb3.getText().toString() + ", ";
            Check[3] = "1";
        } else {
            Check[3] = "0";
        }

        if (cb4.isChecked()) {
            result += cb4.getText().toString() + ", ";
            Check[4] = "1";
        } else {
            Check[4] = "0";
        }

        if (cb5.isChecked()) {
            result += cb5.getText().toString() + ", ";
            Check[5] = "1";
        } else {
            Check[5] = "0";
        }

        if (cb6.isChecked()) {
            result += cb6.getText().toString() + ", ";
            Check[6] = "1";
        } else {
            Check[6] = "0";
        }

        if (cb7.isChecked()) {
            result += cb7.getText().toString() + ", ";
            Check[7] = "1";
        } else {
            Check[7] = "0";
        }

        if (cb8.isChecked()) {
            result += cb8.getText().toString() + ", ";
            Check[8] = "1";
        } else {
            Check[8] = "0";
        }

        if (cb9.isChecked()) {
            result += cb9.getText().toString() + ", ";
            Check[9] = "1";
        } else {
            Check[9] = "0";
        }

        if (cb10.isChecked()) {
            result += cb10.getText().toString() + ", ";
            Check[10] = "1";

        } else {
            Check[10] = "0";
        }
        tv.setText("체크항목: " + result);
    }
    public void onButton1Clicked(View v) {
        // if 체크박스에 아무것도 눌리지 않았으면
        // Toast.makeText(getApplicationContext(), "적어도 하나이상 선택해야 합니다." Toast.LENGTH_SHORT).shwo();
        // else 선택한것이므로 위에 리스트박스에 상호명을 나열.
    }
}

class MyAdapter extends BaseAdapter {

    Context context;   // 현재 화면의 제어권자
    int layout;         // 한 행을 그려줄 레이아웃
    ArrayList al;       // 다량의 데이터
    LayoutInflater inf;     // layout xml 파일을 객체로 전환할때 필요

    public MyAdapter(Context context, int layout, ArrayList al) {// 초기화
        this.context = context;
        this.layout = layout;
        this.al = al;
        this.inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() { // ListView 에서 사용할 데이터의 총개수
        return al.size();
    }

    @Override
    public Object getItem(int position) { // 해당 position번째의 데이터 값
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {// 해당 position번째의 유니크한id 값
        return position;
    }

    public void clear() {
        // clear the data
        al.clear();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //해당행 순서,   해당행 레이아웃,          리스트뷰
        // 한행의 화면을 셋팅하는 메서드 (가장 중요)
        if (convertView == null) {
            convertView = inf.inflate(layout, null);
            //xml파일로 레이아웃객체 생성
        }
        TextView tv = (TextView) convertView.findViewById(R.id.textView10);
        tv.setText(al.get(position).toString()); // 해당번째의 값을 설정

        return convertView;
    }
} // end class MyAdapter

