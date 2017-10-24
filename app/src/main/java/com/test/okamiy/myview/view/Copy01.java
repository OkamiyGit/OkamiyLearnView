package com.test.okamiy.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.test.okamiy.myview.data.Data;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Okamiy on 2017/10/23.
 * Email: 542839122@qq.com
 */

public class Copy01 extends View {

    private final static String NAME = "直方图";

    private List<Data> datas;
    private Paint paint;
    private float startX;
    private float space;
    private float width;
    private float max;

    public Copy01(Context context) {
        super(context);
        init();
    }

    public Copy01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Copy01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        datas = new ArrayList<>();
        Data data = new Data("Froyo", 10.0f, Color.GREEN);
        datas.add(data);
        data = new Data("GB", 18.0f, Color.GREEN);
        datas.add(data);
        data = new Data("ICS", 22.0f, Color.GREEN);
        datas.add(data);
        data = new Data("OKamiy", 27.0f, Color.GREEN);
        datas.add(data);
        data = new Data("L", 40.0f, Color.GREEN);
        datas.add(data);
        data = new Data("MMMM", 65.0f, Color.GREEN);
        datas.add(data);
        data = new Data("IsOne", 25.0f, Color.GREEN);
        datas.add(data);
        data = new Data("Two", 13.0f, Color.GREEN);
        datas.add(data);

        max = Float.MIN_VALUE;
        for (Data d : datas) {
            max = Math.max(max, d.getNumber());
            Log.i(TAG, "init: " + d.getName() + ",,," + max);
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        paint.setTextSize(72);

        canvas.drawText(NAME, (canvas.getWidth() - paint.measureText(NAME)) / 2, canvas.getHeight() * .9f, paint);
        // 将画图原点移动直方图的原点位置
        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.7f);

        width = (canvas.getWidth() * 0.8f - 100) / datas.size() * 0.8f;
        space = (canvas.getWidth() * 0.8f - 100) / datas.size() * .2f;

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, paint);
        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.6f, paint);

        startX = 0f;

        paint.setTextSize(36);
        paint.setStyle(Paint.Style.FILL);
        for (Data d : datas) {
            paint.setColor(d.getColor());
            canvas.drawRect(startX + space, -(d.getNumber() / max * canvas.getHeight() * 0.6f), startX + space + width, -2, paint);
            paint.setColor(Color.WHITE);
            canvas.drawText(d.getName(), startX + space + (width - paint.measureText(d.getName())) / 2, 40, paint);
            startX += width + space;
        }
    }
}
