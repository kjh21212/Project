package com.example.hello.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

public class Ladder extends AppCompatActivity implements Callback {
    // 이름 입력칸 참조
    int[] mNames = { R.id.name1, R.id.name2, R.id.name3, R.id.name4 };
    // 캔버스 참조
    SurfaceView mSurface;
    // 홀더
    SurfaceHolder mHolder;
    // 캔버스 크기
    int mW;
    int mH;
    // 게임 배열 (6*4 배열로 한다.)
    int[][] mLines = new int[6][4];

    // 폴 위치
    float[] mPoles = { 0.12f, 0.37f, 0.63f, 0.88f };
    // 펜
    Paint mPaint;
    // 움직이는 객체
    Mover[] mMovers;
    // 색깔
    int[] mColors = { 0xFFFFCCFF, 0xFFFFFF44, 0xFF7FFFFF, 0xFFFF8888 };
    // 계속 여부
    boolean mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_ladder);

        findViewById(R.id.backbutton2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                }
        );

        // 서피스 터치시 키보드를 사라지게 하기 위해 매니저 호출
        final InputMethodManager ipm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        // 서피스
        mSurface = (SurfaceView) findViewById(R.id.canvas);
        mSurface.setZOrderOnTop(true);
        mSurface.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ipm.toggleSoftInput(0, 0);
            }
        });
        mHolder = mSurface.getHolder();
        mHolder.setFormat(PixelFormat.TRANSPARENT);

        // 이름 참조
        EditText[] names = new EditText[mNames.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = (EditText) findViewById(mNames[i]);
        }

        // 펜
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(5);

        // 시작 버튼
        ImageView start = (ImageView) findViewById(R.id.start);
        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 게임 시작
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        mContinue = true;
                        generate();
                        while (mContinue) {
                            draw();
                            int arrived = 0;
                            for (int i = 0; i < mMovers.length; i++) {
                                if (mMovers[i].arrived)
                                    arrived++;
                            }
                            if (arrived == mMovers.length)
                                mContinue = false;

                            try {
                                Thread.sleep(16);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        // 콜백 설정
        mHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        mW = width;
        mH = height;

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    // 데이터 생성
    void generate() {
        // data generation
        boolean drawn = false;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 3; c++) {
                mLines[r][c] = 0;
            }
        }
        for (int r = 0; r < 6; r++) {
            int rn = (int) (Math.random() * 6);
            if (rn > 3)
                mLines[r][1] = 1;
            else if (rn == 3) {
                mLines[r][0] = 1;
                mLines[r][2] = 1;
            } else
                mLines[r][rn] = 1;
        }

        // set mover
        mMovers = new Mover[4];
        for (int i = 0; i < mMovers.length; i++) {
            mMovers[i] = new Mover();
            mMovers[i].mX = mPoles[i];
            mMovers[i].dX = mPoles[i];
            mMovers[i].mY = 0;
            mMovers[i].idX = i;
            mMovers[i].dY = 0.2f;
            mMovers[i].directionY = 1;
            mMovers[i].color = mColors[i];
        }

    }

    void draw() {

        // 그리기 시작
        Canvas canvas = mHolder.lockCanvas();
        canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);
        mPaint.setColor(Color.WHITE);
        // 폴
        for (int i = 0; i < mPoles.length; i++) {
            canvas.drawLine(mPoles[i] * mW, 0, mPoles[i] * mW, mH, mPaint);
        }
        // 가로대
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 3; c++) {
                if (mLines[r][c] == 1) {
                    canvas.drawLine(mPoles[c] * mW,
                            (int) ((0.2 + r * 0.1) * mH), mPoles[c + 1] * mW,
                            (int) ((0.2 + r * 0.1) * mH), mPaint);
                }
            }
        }
        // 무버
        for (int i = 0; i < mMovers.length; i++) {
            mMovers[i].move();
            mMovers[i].draw(canvas, mPaint);
        }

        mHolder.unlockCanvasAndPost(canvas);
    }

    class Mover {
        // 현재 물리적 위치
        public float mX, mY;
        // 가야 할 물리적 위치
        public float dX, dY;
        // 가야 할 좌표적 위치
        public int idX, idY;
        // 도착 여부
        public boolean arrived;
        int directionY = 0;
        int directionX = 0;
        float speed = 0.1f;
        public int color;

        void setDestination(int x, int y) {

            idX = x;
            idY = y;
            dX = mPoles[x];
            dY = 0.2f + y * 0.1f;

            if (Math.abs(mX - dX) < Math.abs(mY - dY))
                directionY = 1;
            else {
                if (mX < dX)
                    directionX = 1;
                else
                    directionX = -1;
            }
        }

        void move() {
            if (arrived)
                return;
            mX += directionX * speed;
            mY += directionY * speed;
            // Log.e("098","moving to "+dX+","+dY+", current :"+mX+","+mY+", direction :"+directionX+","+directionY);
            if (Math.abs(mX - dX) < speed && Math.abs(mY - dY) < speed) {
                // Log.d("098",idX+","+idY+" 도착");

                mX = dX;
                mY = dY;
                // 다음 진행할 곳
                // 처음이면 무조건 아래로
                if (mY == 0) {
                    dY = 0.2f;
                    idY = 0;
                }
                // 바닥 도착이면 종료
                else if (dY == 1) {
                    // Log.e("098", "arrive!");
                    arrived = true;
                    return;
                }
                // 수평으로 움직였다면 다음은 무조건 수직
                else if (directionX != 0) {
                    directionX = 0;
                    if (idY == mLines.length - 1) {
                        // 마지막
                        // Log.d("098","마지막 아래로..");
                        dY = 1;
                        directionY = 1;
                    } else {
                        // Log.d("098","수평으로 왔으니 아래로..");
                        setDestination(idX, idY + 1);
                    }
                }
                // 수직으로 움직였으면 좌우 라인을 탐색한다.
                else {
                    directionY = 0;
                    // 우측 라인
                    if (mLines[idY][idX] == 1) {
                        setDestination(idX + 1, idY);
                    }
                    // 좌측라인
                    else if (idX > 0 && mLines[idY][idX - 1] == 1) {
                        setDestination(idX - 1, idY);
                    } else {
                        //
                        // Log.d("098","좌우 길 없음 아래로..");
                        if (idY < mLines.length - 1)
                            setDestination(idX, idY + 1);
                        else {
                            // 마지막 줄은 바닥행
                            dY = 1;
                            directionY = 1;
                        }
                    }
                }
            }
        }

        void draw(Canvas canvas, Paint paint) {
            paint.setColor(color);
            canvas.drawCircle(mX * mW, mY * mH, 35, paint);
        }
    }
}
