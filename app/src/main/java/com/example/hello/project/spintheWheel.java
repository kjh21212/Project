package com.example.hello.project;

/**
 * Created by ask57 on 2016-11-20.
 */

        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.graphics.Rect;
        import android.graphics.RectF;
        import android.os.SystemClock;
        import android.util.AttributeSet;
        import android.util.TypedValue;
        import android.view.SurfaceHolder;
        import android.view.SurfaceView;

        import java.util.Random;

public class spintheWheel extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private Thread mThread;
    private Boolean mIsRunning = false;
    private String[] mTexts = new String[]
            {"1", "2", "3", "4", "5", "6","7", "8"};

    private Bitmap mBackgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background);
    private int[] mColors = new int[]
            {0xFFffd333, 0xFFffb651, 0xFFffd333, 0xFFffb651,0xFFffd333, 0xFFffb651,0xFFffd333, 0xFFffb651};

    private int mItemCount = 8;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private float mTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics());
    private RectF mRangeRectF;
    private int mDiameter;
    private int mCenter;
    private int mPadding;
    private double mSpeed = 0;
    private volatile float mStartAngle = 0;
    private boolean mShouldStop;

    public spintheWheel(Context context) {
        this(context, null);
    }

    public spintheWheel(Context context, AttributeSet attrs) {
        super(context, attrs);

        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
    }

    /**
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = Math.min(getMeasuredWidth(), getMeasuredHeight());

        mPadding = getPaddingLeft();
        mDiameter = width - mPadding * 2;
        mCenter = width / 2;
        setMeasuredDimension(width, width);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setDither(true);

        mTextPaint = new Paint();
        mTextPaint.setColor(0xFFFFFFFF);
        mTextPaint.setTextSize(mTextSize);

        mRangeRectF = new RectF(mPadding, mPadding, mPadding + mDiameter, mPadding + mDiameter);


        mIsRunning = true;

        mThread = new Thread(this);
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsRunning = false;
    }

    @Override
    public void run() {
        while (mIsRunning) {
            long start = System.currentTimeMillis();
            draw();
            long end = System.currentTimeMillis();
            if (end - start < 50) {
                SystemClock.sleep(50 - (end - start));
            }
        }
    }

    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            if (mCanvas != null) {
                //draw something
                drawBackground();

                float startAngle = mStartAngle;
                float sweepAngle = 360 / mItemCount;

                for (int i = 0; i < mItemCount; i++) {
                    mArcPaint.setColor(mColors[i]);
//                    startAngle = i * sweepAngle;
                    mCanvas.drawArc(mRangeRectF, startAngle, sweepAngle, true, mArcPaint);

                    drawText(startAngle, sweepAngle, mTexts[i]);
                    startAngle += sweepAngle;
                }

                mStartAngle += mSpeed;

                if (mShouldStop) {
                    mSpeed--;
                }

                if (mSpeed <= 0) {
                    mSpeed = 0;
                    mShouldStop = false;
                }
            }
        } finally {
            if (mCanvas != null) {
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }

    public void start(int index) {
        float angle = 360 / mItemCount;


        float from = 270 - (index + 1) * angle;
        float end = from + angle;

        float targetFrom = 4 * 360 + from;
        float targetEnd = 4 * 360 + end;

        float v1 = (float) ((-1 + Math.sqrt(1 + 8 * targetFrom)) / 2);
        float v2 = (float) ((-1 + Math.sqrt(1 + 8 * targetEnd)) / 2);

        mSpeed = v1 + Math.random() * (v2 - v1);
        mShouldStop = false;
    }

    public void stop() {
        mStartAngle = (float)(Math.random()*8);
        mShouldStop = true;
    }


    public boolean isShouldStop() {
        return mShouldStop;
    }

    public boolean isStarting() {
        return mSpeed != 0;
    }

    private void drawText(float startAngle, float sweepAngle, String text) {
        Path path = new Path();
        path.addArc(mRangeRectF, startAngle, sweepAngle);

        float textWidth = mTextPaint.measureText(text);
//        int hOffset = (int) (mDiameter * Math.PI / mItemCount / 2 - textWidth / 2);
        int hOffset = (int)(Math.PI / 4  * mDiameter / 2 / 2 - textWidth / 2);
        int vOffset = mDiameter / 2 / 8;
        mCanvas.drawTextOnPath(text, path, hOffset, vOffset, mTextPaint);
    }

    private void drawBackground() {
        mCanvas.drawColor(0xFFFFFFFF);

        mCanvas.drawBitmap(mBackgroundBitmap, null, new Rect(mPadding / 2, mPadding / 2, getMeasuredWidth() - mPadding / 2, getMeasuredHeight() - mPadding / 2), null);
//        mCanvas.drawBitmap(mBackgroundBitmap, null, new Rect(mPadding, mPadding, mPadding + mDiameter, mPadding + mDiameter), null);
    }
}
