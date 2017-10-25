package com.test.okamiy.myview;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    List<PageMode> mList = new ArrayList<>();
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.pager)
    ViewPager mPager;

    {
        mList.add(new PageMode(R.layout.sample_histogram, R.string.draw_his, R.layout.item_views));
        mList.add(new PageMode(R.layout.sample_pie, R.string.pie_chart, R.layout.item_view_oral));
        mList.add(new PageMode(R.layout.sample_circle, R.string.circle_chart, R.layout.item_views_arc));
        mList.add(new PageMode(R.layout.sample_heart, R.string.love_heart, R.layout.item_views_heart));
        mList.add(new PageMode(R.layout.sample_bitmap, R.string.include_bitmap, R.layout.item_views_bitmap));
        mList.add(new PageMode(R.layout.sample_heart, R.string.include_bitmap, R.layout.item_views_shader));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageMode pageMode = mList.get(position);
                return PagerFragment.newInstance(pageMode.sampleLayoutRes, pageMode.drawLayoutRes);
            }

            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(mList.get(position).titleRes);
            }
        });
        mTablayout.setupWithViewPager(mPager);
    }

    private class PageMode {
        @LayoutRes
        int sampleLayoutRes;
        @LayoutRes
        int drawLayoutRes;
        @StringRes
        int titleRes;

        PageMode(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int drawLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.drawLayoutRes = drawLayoutRes;
            this.titleRes = titleRes;
        }
    }
}
