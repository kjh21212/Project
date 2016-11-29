package com.example.hello.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.hello.project.TournamentStart.count;

public class Tournament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        TextView tv1 = (TextView)findViewById(R.id.tView1);
        TextView tv2 = (TextView)findViewById(R.id.tView2);
        TextView tv3 = (TextView)findViewById(R.id.tView4);
        findViewById(R.id.backbutton5).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), TournamentStart.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.tView1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if((TournamentStart.count)!=6) {
                            if((TournamentStart.count)<4) {
                                TournamentStart.num[TournamentStart.count]=TournamentStart.num[(TournamentStart.count)*2];
                            }
                            else{
                                TournamentStart.num[TournamentStart.count-4]=TournamentStart.num[(TournamentStart.count*2)-8];
                            }

                            Intent intent = new Intent(getApplicationContext(), Tournament.class);
                            startActivity(intent);
                            TournamentStart.count++;
                        }
                        else{
                            Intent intent = new Intent(getApplicationContext(), TournamentFinish.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        findViewById(R.id.tView2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if((TournamentStart.count)!=6) {
                            if((TournamentStart.count)<4) {
                                TournamentStart.num[TournamentStart.count]=TournamentStart.num[(TournamentStart.count)*2+1];
                            }
                            else{
                                TournamentStart.num[(TournamentStart.count)-4]=TournamentStart.num[(TournamentStart.count)*2-7];
                            }
                            Intent intent = new Intent(getApplicationContext(), Tournament.class);
                            startActivity(intent);
                            TournamentStart.count++;
                        }
                        else{
                            TournamentStart.num[(TournamentStart.count)-6]=TournamentStart.num[(TournamentStart.count*2)-11];
                            Intent intent = new Intent(getApplicationContext(), TournamentFinish.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        if(count<4){
            tv3.setText("8강");
            tv1.setBackgroundResource(TournamentStart.num[count*2]);
            tv2.setBackgroundResource(TournamentStart.num[count*2+1]);
        }
        else if(count>3 && count<6){
            tv3.setText("4강");
            tv1.setBackgroundResource(TournamentStart.num[count*2-8]);
            tv2.setBackgroundResource(TournamentStart.num[count*2-7]);
        }
        else{
            tv3.setText("결승");
            tv1.setBackgroundResource(TournamentStart.num[count*2-12]);
            tv2.setBackgroundResource(TournamentStart.num[count*2-11]);
        }

    }
}