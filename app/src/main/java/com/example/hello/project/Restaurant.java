package com.example.hello.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.content.ContextCompat;

public class Restaurant extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);


        //한식 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo1),
                "구공탄", "02-3401-0010") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo2),
                "눈물닭발", "02-921-2155") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo3),
                "땡초불닭발", "02-6326-4142") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo4),
                "마산아구찜", "02-928-0888") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo5),
                "명인찜닭", "02-953-5343") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo6),
                "미가도시락", "02-2265-2277") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo7),
                "박가네부대전골", "02-925-1118") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo8),
                "볶음세상", "02-927-9733") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo9),
                "뿔난돼지신곱창", "02-922-9666") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo10),
                "수상한불닭발", "02-923-3070") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo11),
                "신화불골뱅이", "02-927-9733") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo12),
                "안동촌찜닭", "02-929-2999") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo13),
                "어가해물찜", "02-929-2999") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo14),
                "흥보네안동찜닭", "02-953-2333") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo15),
                "영월쌈밥", "02-923-3070") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo16),
                "의정부부대찌개&감자탕", "02-6082-5559") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo17),
                "원할매보쌈족발", "02-928-0888") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo18),
                "장충동가마솥왕족발보쌈", "02-6326-0200") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo19),
                "장충동한양왕족발굴보쌈", "02-6082-5559") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo20),
                "참조은웰빙쌈밥", "02-953-2333") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo21),
                "추풍령할매감자탕", "02-921-2155") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.logo22),
                "한솥명가갈비찜", "02-6326-4142") ;


        findViewById(R.id.backbutton1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );
    }

}