package com.example.hello.project;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        //한식메뉴
        if(name.equals("구공탄"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea1);
            ImageView image = (ImageView)findViewById(R.id.menuImage);

            image.setImageDrawable(drawable);
        }
        else if(name.equals("눈물닭발"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea2);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("땡초불닭발"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea3);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("마산아구찜"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea4);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("명인찜닭"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea5);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("미가도시락"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea6);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("박가네부대전골"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea7);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("볶음세상"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea8);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("뿔난돼지신곱창"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea9);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("수상한불닭발"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea10);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("신화불골뱅이"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea11);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("안동촌찜닭"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea12);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("어가해물찜"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea13);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("흥보네안동찜닭"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea14);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("영월쌈밥"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea15);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("의정부부대찌개"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea16);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("원할매보쌈족발"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea17);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("장충동가마솥왕족발"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea18);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("장충동한양왕족발"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea19);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("참조은웰빙쌈밥"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea20);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("추풍령할매감자탕"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea21);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("한솥명가갈비찜"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.korea22);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }


        //중식메뉴
        else if(name.equals("남경"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.china1);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("동국반점"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.china2);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("사해루"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.china3);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("아리산"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.china4);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }

        //일식메뉴
        else if(name.equals("미스터돈가스"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.japan1);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }

        //양식메뉴
        else if(name.equals("59쌀피자"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston1);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("교촌치킨"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston2);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("깐부치킨"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston3);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("네네치킨"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston4);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("몬테피자"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston5);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("미스터피자"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston6);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("미쳐버린파닭"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston7);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("위대한치킨24시"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston8);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("치킨의전설"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston9);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("파파이스"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston10);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("피막치골"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston11);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("피자나라치킨공주"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston12);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("ICG"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.weston13);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }


        //분식메뉴
        else if(name.equals("김가네"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.flour1);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("나래분식"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.flour2);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("신당동해물떡볶이"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.flour3);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("동대문엽기떡볶이"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.flour4);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("용우동"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.flour5);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("윤떡"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.flour6);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
        else if(name.equals("진아네떡볶이"))
        {
            Drawable drawable = getResources().getDrawable(R.drawable.flour7);
            ImageView image = (ImageView)findViewById(R.id.menuImage);
            image.setImageDrawable(drawable);
        }
    }
}
