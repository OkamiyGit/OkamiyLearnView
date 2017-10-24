package com.test.okamiy.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Okamiy on 2017/10/19.
 * Email: 542839122@qq.com
 */

public class DemoView3 extends View {
    private Paint mPaint;
    private int left, right, top, bottom;
    private RectF mRectF;

    public DemoView3(Context context) {
        super(context);
        init();
    }

    public DemoView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制弧形
        mRectF = new RectF((left + 200), (bottom / 2 - 300), (right - 200), (bottom / 2 + 300));
        drawArc(canvas);
    }

    private void drawArc(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc((left + 200), (bottom / 2 - 300), (right - 200), (bottom / 2 + 300), 20, 70, true, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawArc(mRectF, 100, 80, false, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(mRectF, 210, 130, false, mPaint);

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
