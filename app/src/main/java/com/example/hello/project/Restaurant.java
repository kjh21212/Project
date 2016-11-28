package com.example.hello.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;

public class Restaurant extends AppCompatActivity{
    ListView listview = null;
    ListViewAdapter adapter = null;

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurant);

        listview = (ListView )findViewById(R.id.listview1);
        // Adapter 생성
        adapter = new ListViewAdapter(this);

        listview.setAdapter(adapter);

        findViewById(R.id.korea).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        adapter.clear();
                        listview.setAdapter(null);
                        listview.setAdapter(adapter);
                        adapter.addItem(getResources().getDrawable(R.drawable.logo1),
                                "구공탄", "02-3401-0010");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo2),
                                "눈물닭발", "02-921-2155");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo3),
                                "땡초불닭발", "02-6326-4142");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo4),
                                "마산아구찜", "02-928-0888");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo5),
                                "명인찜닭", "02-953-5343");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo6),
                                "미가도시락", "02-2265-2277");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo7),
                                "박가네부대전골", "02-925-1118");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo8),
                                "볶음세상", "02-927-9733");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo9),
                                "뿔난돼지신곱창", "02-922-9666");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo10),
                                "수상한불닭발", "02-923-3070");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo11),
                                "신화불골뱅이", "02-927-9733");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo12),
                                "안동촌찜닭", "02-929-2999");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo13),
                                "어가해물찜", "02-929-2999");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo14),
                                "흥보네안동찜닭", "02-953-2333");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo15),
                                "영월쌈밥", "02-923-3070");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo16),
                                "의정부부대찌개", "02-6082-5559");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo17),
                                "원할매보쌈족발", "02-928-0888");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo18),
                                "장충동가마솥왕족발", "02-6326-0200");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo19),
                                "장충동한양왕족발", "02-6082-5559");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo20),
                                "참조은웰빙쌈밥", "02-953-2333");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo21),
                                "추풍령할매감자탕", "02-921-2155");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo22),
                                "한솥명가갈비찜", "02-6326-4142");
                    }
                }
        );
        findViewById(R.id.china).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        adapter.clear();
                        listview.setAdapter(null);
                        listview.setAdapter(adapter);
                        adapter.addItem(getResources().getDrawable(R.drawable.logo23china),
                                "남경", "02-2277-2700");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo24china),
                                "동국반점", "02-2252-8800");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo25china),
                                "사해루", "02-2266-3482");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo26china),
                                "아리산", "02-2275-3233");
                    }
                }
        );
        findViewById(R.id.japan).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        adapter.clear();
                        listview.setAdapter(null);
                        listview.setAdapter(adapter);
                        adapter.addItem(getResources().getDrawable(R.drawable.logo27japan),
                                "미스터돈가스", "02-2233-9909");
                    }
                }
        );
        findViewById(R.id.weston).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        adapter.clear();
                        listview.setAdapter(null);
                        listview.setAdapter(adapter);
                        adapter.addItem(getResources().getDrawable(R.drawable.logo28weston),
                                "59쌀피자", "02-2256-5949");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo29weston),
                                "교촌치킨", "02-2237-9952");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo30weston),
                                "깐부치킨", "02-2231-1366");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo31weston),
                                "네네치킨", "02-3675-0388");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo32weston),
                                "몬테피자", "02-2237-7707");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo33weston),
                                "미스터피자", "02-2254-3611");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo34weston),
                                "미쳐버린파닭", "02-2274-2237");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo35weston),
                                "위대한치킨24시", "02-6052-7268");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo36weston),
                                "치킨의전설", "02-6326-5550");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo37weston),
                                "파파이스", "02-2264-8854");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo38weston),
                                "피막치골", "02-2233-7787");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo39weston),
                                "피자에땅", "02-2235-5678");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo40weston),
                                "피자나라치킨공주", "02-2277-9213");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo41weston),
                                "ICG", "02-2268-9282");
                    }
                }
        );
        findViewById(R.id.flour).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        adapter.clear();
                        listview.setAdapter(null);
                        listview.setAdapter(adapter);
                        adapter.addItem(getResources().getDrawable(R.drawable.logo42flour),
                                "김가네", "02-2269-7011");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo43flour),
                                "나래분식", "02-2263-3759");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo44flour),
                                "신당동해물떡볶이", "02-923-3070");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo45flour),
                                "동대문엽기떡볶이", "02-2275-8592");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo46flour),
                                "용우동", "02-2269-0915");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo47flour),
                                "윤떡", "02-2272-2268");
                        adapter.addItem(getResources().getDrawable(R.drawable.logo48flour),
                                "진아네떡볶이", "011-318-1240");
                    }
                }
        );

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String vo = (String) parent.getAdapter().getItem(position);
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                intent.putExtra("name",vo);
                startActivity(intent);
            }
        });

    }

}