package com.example.hello.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/*
    강현규 작업
*/
public class TournamentFinish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_finish);

        TextView tv3=(TextView)findViewById(R.id.tView3);
        findViewById(R.id.backbutton98).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );

        tv3.setBackgroundResource(TournamentStart.num[0]);

    }
}