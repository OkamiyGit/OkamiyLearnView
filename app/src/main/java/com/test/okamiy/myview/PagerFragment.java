package com.test.okamiy.myview;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Okamiy on 2017/10/19.
 * Email: 542839122@qq.com
 */

public class PagerFragment extends Fragment {
    @LayoutRes
    int drawLayoutRes;
    int sampleLayoutRes;
    @BindView(R.id.sampleStub)
    ViewStub mSampleStub;
    @BindView(R.id.drawStub)
    ViewStub mDrawStub;
    private Unbinder unbind;

    public static PagerFragment newInstance(@LayoutRes int sampleLayoutRes, @LayoutRes int drawLayoutRes) {
        PagerFragment pagerFragment = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("sampleLayoutRes", sampleLayoutRes);
        bundle.putInt("drawLayoutRes", drawLayoutRes);
        pagerFragment.setArguments(bundle);
        return pagerFragment;


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        unbind = ButterKnife.bind(this, view);
        mDrawStub.setLayoutResource(drawLayoutRes);
        mDrawStub.inflate();

        mSampleStub.setLayoutResource(sampleLayoutRes);
        mSampleStub.inflate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (null != bundle) {
            drawLayoutRes = bundle.getInt("drawLayoutRes");
            sampleLayoutRes = bundle.getInt("sampleLayoutRes");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }
}
