package com.example.hello.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.Menu;
import android.widget.AdapterView;

public class Select extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView text1;

    /**
     * 스피너를 위한 아이템 정의
     * 스피너에 보여줄 아이템 리스트
     */
    String[] items_korea = {"선택","구공탄","눈물닭발","땡초불닭발","마산아구찜","명인찜닭","미기도시락","박가네부대전골","볶음세상","뿔난돼지신곱창","수상한곱창불닭발","신화불골뱅이","안동촌찜닭","어가해물찜","영월쌈밥","원조의정부부대찌개","원할매보쌈족발","장충동가마솥","장충동한양왕족발","참조은웰빙쌈","추풍령할매감자탕","한솥명가갈비찜","흥보네안동찜닭"};
    String[] items_china = {"선택","강서","남경","동국반점","사해루","아리산","필동반점"};
    String[] items_weston = {"선택","59피자","교촌치킨","깐부치킨","네네치킨","몬테피자","미스터피자","미쳐버린파닭","위대한치킨24시","치킨의전설","파파이스","피막치골","피자에땅","피자나라치킨공주","ICG"};
    String[] items_japan = {"선택","미스터돈까스"};
    String[] items_flour = {"선택","김가네","나래분식","신당동 해물떡볶이","엽기떡볶이","용우동","윤떡","진아네떡볶이"};
    static String[] select1={"","","",""};
    protected String[] select2={"","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        text1 = (TextView) findViewById(R.id.text1);

        // 스피너 객체 참조
        final Spinner spin = (Spinner) findViewById(R.id.spinner);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spin3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spin4 = (Spinner) findViewById(R.id.spinner4);
        Spinner spin5 = (Spinner) findViewById(R.id.spinner5);

        //스피너에 아이템을 클릭 했을때 실행될 리스너(액티비티)
        spin.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);
        spin4.setOnItemSelectedListener(this);
        spin5.setOnItemSelectedListener(this);
        /*
         * 어댑터 배열 객체 생성(this는 Context 메인 액티비티를 가리킴,
         * 안드로이드에 있는 어댑터 객체 에서 지원해주는 스피너 레이아웃,아이템 배열)
         * android는 안드로이드가 가지고 있는 전역 변수
         */
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items_korea);
        //adapter를 통해 리스트 형태로 늘리는 메소드
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 어댑터 설정
        spin.setAdapter(adapter);

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items_china);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);

        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items_weston);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter3);

        final ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items_japan);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(adapter4);

        final ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items_flour);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(adapter5);

        Intent intent = getIntent();
        final int count = intent.getExtras().getInt("count");

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //첫번째 spinner 클릭시 이벤트 발생입니다. setO 정도까지 치시면 자동완성됩니다. 뒤에도 마찬가지입니다.
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (adapter.getItem(position).toString() != adapter.getItem(0).toString()) {
                    if(count<4)
                        select1[count] = adapter.getItem(position).toString();
                    else
                        select2[count-4] = adapter.getItem(position).toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (adapter2.getItem(position).toString() != adapter2.getItem(0).toString()) {
                    if(count<4)
                        select1[count] = adapter2.getItem(position).toString();
                    else
                        select2[count-4] = adapter2.getItem(position).toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (adapter3.getItem(position).toString() != adapter3.getItem(0).toString()) {
                    if(count<4)
                        select1[count] = adapter3.getItem(position).toString();
                    else
                        select2[count-4] = adapter3.getItem(position).toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (adapter4.getItem(position).toString() != adapter4.getItem(0).toString()) {
                    if(count<4)
                        select1[count] = adapter4.getItem(position).toString();
                    else
                        select2[count-4] = adapter4.getItem(position).toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (adapter5.getItem(position).toString() != adapter5.getItem(0).toString()) {
                    if(count<4)
                        select1[count] = adapter5.getItem(position).toString();
                    else
                        select2[count-4] = adapter5.getItem(position).toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        findViewById(R.id.backbutton).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if(count<4) {
                            Intent intent = new Intent(getApplicationContext(), Ladder.class);
                            intent.putExtra("select1", select1[count]);
                            intent.putExtra("i", count);
                            startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), Wheel.class);
                        intent.putExtra("select1", select2[count-4]);
                        intent.putExtra("i", count);
                        startActivity(intent);
                    }
                    }
                }
        );

    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
    }
    /**
         * 아무것도 선택되지 않았을 때 처리
         * AdapterView.OnItemSelectedListener에 인터페이스 된 메소드
         */
    public void onNothingSelected(AdapterView<?> parent) {
    }
    //인플레이터로 만들어진 메뉴
    //환경설정 버튼을 클릭했을시 보여줄 메뉴를 만들어주는 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        //안드로이드에서 기본 지원 해주는 memu를 보여줌
        //setting메뉴만 등장함, 클릭시 변화가 없음

        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
