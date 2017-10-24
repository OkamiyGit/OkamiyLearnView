package com.test.okamiy.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Okamiy on 2017/10/19.
 * Email: 542839122@qq.com
 */

public class DemoView2 extends View {
    private static final String TAG = "DemoView2";
    private Paint mPaint;
    private int left, right, top, bottom;
    private int r;
    private RectF mRectF, outRectF;
    private Path mPath;
    private int mLeft;
    private int mTop;

    public DemoView2(Context context) {
        super(context);
        init();
    }

    public DemoView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        //绘制圆饼
        drawArc(canvas);
    }


    private void getPoint(int i, Canvas canvas) {
        Point point = new Point();
        point.x = (int) (mLeft + r * Math.cos(i * Math.PI / 180));
        point.y = (int) (mTop + r * Math.sin(i * Math.PI / 180));

        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

        switch (i) {
            case 6:
                mPath.moveTo(point.x, point.y);
                mPath.lineTo(point.x + 30, point.y + 30);
                mPath.lineTo(point.x + 120, point.y + 30);
                canvas.drawPath(mPath, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText("你好，Text", point.x + 125, point.y + 30, mPaint);
                mPath.reset();
                mPaint.reset();
                break;
            case 28:
                mPath.moveTo(point.x, point.y);
                mPath.lineTo(point.x + 30, point.y + 30);
                mPath.lineTo(point.x + 120, point.y + 30);
                canvas.drawPath(mPath, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText("明天！！！", point.x + 125, point.y + 30, mPaint);
                mPath.reset();
                mPaint.reset();
                break;
            case 65:
                mPath.moveTo(point.x, point.y);
                mPath.lineTo(point.x + 30, point.y + 30);
                mPath.lineTo(point.x + 120, point.y + 30);
                canvas.drawPath(mPath, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText("Okamiy", point.x + 125, point.y + 30, mPaint);
                mPath.reset();
                mPaint.reset();
                break;
            case 133:
                mPath.moveTo(point.x, point.y);
                mPath.lineTo(point.x - 30, point.y + 30);
                mPath.lineTo(point.x - 120, point.y + 30);
                canvas.drawPath(mPath, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText("MondayOfToday", point.x - 127 - (mPaint.measureText("MondayOfToday")), point.y + 30, mPaint);
                mPath.reset();
                mPaint.reset();
                break;
            case 242:
                mPath.moveTo(point.x, point.y);
                mPath.lineTo(point.x - 30, point.y - 30);
                mPath.lineTo(point.x - 120, point.y - 30);
                canvas.drawPath(mPath, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText("666哈哈哈", point.x - 127 - (mPaint.measureText("666哈哈哈")), point.y - 30, mPaint);
                mPath.reset();
                mPaint.reset();
                break;
            case 331:
                mPath.moveTo(point.x, point.y);
                mPath.lineTo(point.x + 30, point.y - 30);
                mPath.lineTo(point.x + 120, point.y - 30);
                canvas.drawPath(mPath, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText("一年四季", point.x + 125, point.y - 30, mPaint);
                mPath.reset();
                mPaint.reset();
                break;
            default:
                break;
        }
    }

    private void drawArc(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawArc(mRectF, 0, 12, true, mPaint);
        getPoint(6, canvas);

        mPaint.setColor(Color.GRAY);
        canvas.drawArc(mRectF, 13, 30, true, mPaint);
        getPoint(28, canvas);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(mRectF, 44, 42, true, mPaint);
        getPoint(65, canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(mRectF, 87, 93, true, mPaint);
        getPoint(133, canvas);

        mPaint.setColor(Color.BLACK);
        canvas.drawArc(outRectF, 182, 120, true, mPaint);
        getPoint(242, canvas);

        mPaint.setColor(Color.BLUE);
        canvas.drawArc(mRectF, 303, 56, true, mPaint);
        getPoint(331, canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        r = Math.min(right / 2, bottom / 2) - 110;
        if (right >= bottom) {
            mRectF = new RectF((right / 2) - r, 110, (right / 2) + r, bottom - 110);
            outRectF = new RectF((right / 2) - r - 10, 100, (right / 2) + r - 10, bottom - 120);
            mLeft = right / 2;
            mTop = bottom / 2;
        } else {
            mRectF = new RectF(110, (bottom / 2) - r, right - 110, (bottom / 2) + r);
            outRectF = new RectF(100, (bottom / 2) - r - 10, right - 120, (bottom / 2) + r - 10);
            mLeft = right / 2;
            mTop = bottom / 2;
        }
    }
}
