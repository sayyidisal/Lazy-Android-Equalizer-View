package com.ais.lazylibequalizer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class LazyEqualizer extends SurfaceView implements SurfaceHolder.Callback {

        public static final int DEFAULT_COLOR = Color.MAGENTA;
        public static final int DEFAULT_BAR_NUM_COUNT = 100;
        public static final int DEFAULT_BAR_SPACING = 12;
        public static final int DEFAULT_SPEED = 600;
        public static final int DEFAULT_BAR_WIDTH = 10;
        public static final int DEFAULT_DEFAULT_BG = Color.WHITE;
        public static final int DEFAULT_BAR_MAX_HEIGHT = 130;


        private SurfaceHolder surfaceHolder = null;
        private Paint paint = null;
        private Timer timer = null;
        private TimerTask task = null;

        int bColor = DEFAULT_COLOR;
        int mBarCount = DEFAULT_BAR_NUM_COUNT;
        int barSpc = DEFAULT_BAR_SPACING;
        int speed = DEFAULT_SPEED;
        float width = DEFAULT_BAR_WIDTH;
        int height = 0;
        int bgColor = DEFAULT_DEFAULT_BG;
        int barHeightmax = DEFAULT_BAR_MAX_HEIGHT;
        float x = barSpc, y = 0;


        public LazyEqualizer(Context context, AttributeSet attrs) {
        super(context, attrs);
        x = barSpc;
        setFocusable(true);
        surfaceHolder = this.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFormat(PixelFormat.TRANSPARENT);
        setZOrderOnTop(true);
        paint = new Paint();
        paint.setColor(bColor);
        getAttrs(context, attrs);
        }

        private void getAttrs(Context context, AttributeSet attrs) {

            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.srfconfig, 0, 0);

            try {
                bColor = a.getInt(R.styleable.srfconfig_barColor, DEFAULT_COLOR);
                mBarCount = a.getInt(R.styleable.srfconfig_barCount, DEFAULT_BAR_NUM_COUNT);
                barSpc = a.getInt(R.styleable.srfconfig_barSpacing, DEFAULT_BAR_SPACING);
                speed = a.getInt(R.styleable.srfconfig_barSpeed, DEFAULT_SPEED);
                width = a.getFloat(R.styleable.srfconfig_barWidth, DEFAULT_BAR_WIDTH);
                bgColor = a.getInt(R.styleable.srfconfig_bgColor, DEFAULT_DEFAULT_BG);
                barHeightmax = a.getInt(R.styleable.srfconfig_max_barHeight, DEFAULT_BAR_MAX_HEIGHT);
            } finally {
                a.recycle();
            }
        }

        public void draw() {
            Canvas canvas = this.getHolder().lockCanvas();
            canvas.drawColor(bgColor);

            final Random rand = new Random();
            ArrayList<Canvas> mCanvas = new ArrayList<>();
            for (int i = 0; i < mBarCount; i++) {
                height = rand.nextInt(barHeightmax);
                canvas.translate(x, y);
                canvas.drawRect(0, 0, width, height, paint);
            }
            mCanvas.add(canvas);
            canvas.save();
            this.getHolder().unlockCanvasAndPost(canvas);
        }

        public void startView() {
            timer = new Timer();
            task = new TimerTask() {

                @Override
                public void run() {
                    draw();
                }
            };
            timer.schedule(task, 0, speed);
        }

        public void stopView() {
            if (timer != null) {
                timer.cancel();
                timer = null;
            }
        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            stopView();

        }

}