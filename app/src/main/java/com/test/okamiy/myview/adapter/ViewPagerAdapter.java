package com.test.okamiy.myview.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Okamiy on 2017/10/19.
 * Email: 542839122@qq.com
 */

public class ViewPagerAdapter extends PagerAdapter {

    private final List<View> mList;
    private final LayoutInflater inflate;

    public ViewPagerAdapter(Context context, List<View> mList) {
        this.inflate = LayoutInflater.from(context);
        this.mList = mList;
    }

    //显示的页面
    @Override
    public int getCount() {
        return mList.size();
    }

    //判断初始化返回的Object是不是一个View对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //初始化显示的条目对象
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mList.get(position);
        container.addView(view);
        return view;

    }

    //销毁目标对象
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
