package com.test.okamiy.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Okamiy on 2017/10/19.
 * Email: 542839122@qq.com
 */

public class DemoView1 extends View {
    private Paint mPaint;
    private int left, right, top, bottom;
    private Path mPath;
    private String[] contet = new String[]{"Froyo", "GB", "ICS", "HuoWei", "M"};

    public DemoView1(Context context) {
        super(context);
        init();
    }

    public DemoView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制坐标轴
        drawXY(canvas);
        //绘制文字
        drawText(canvas);
        //绘制柱状图
        drawLine(canvas);
    }

    private void drawLine(Canvas canvas) {
        mPaint.reset();
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);
        for (int i = 0; i < contet.length; i++) {
            float random = 10 + new Random().nextInt(400);
            mPath.moveTo(i * 140 + (left + 160 + 20), bottom - 163);
            mPath.lineTo(i * 140 + (left + 160 + 20), bottom - (163 + random));
            mPath.lineTo(i * 140 + (left + 160 + 140), bottom - (163 + random));
            mPath.lineTo(i * 140 + (left + 160 + 140), bottom - 163);
            mPath.close();
            canvas.drawPath(mPath, mPaint);
        }
    }

    private void drawText(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(30);
        for (int i = 0; i < contet.length; i++) {
            canvas.drawText(contet[i], (left + 160 + i * 140 + (80 - mPaint.measureText(contet[i]) / 2)), bottom - 130, mPaint);
        }

        mPaint.reset();
        mPaint.setStrokeWidth(7);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(50);
        canvas.drawText("直方图", (right / 2 - mPaint.measureText("直方图") / 2), bottom - 70, mPaint);
    }

    private void drawXY(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        canvas.drawLine(left + 160, bottom - 160, right - 160, bottom - 160, mPaint);
        canvas.drawLine(left + 160, top + 160, left + 160, bottom - 160, mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }
}
