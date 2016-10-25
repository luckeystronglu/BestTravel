package com.qf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qf.besttravel.MakeOrderActivity;
import com.qf.besttravel.R;
import com.qfkf.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2016/9/30.
 */
public class TravelOrderFragment extends BaseFragment {

    @Bind(R.id.travel_order_tv)
    TextView travelOrderTv;

    @Override
    protected int getContentView() {
        return R.layout.fragment_travelorder;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.travel_order_tv)
    public void onClick() {
        startActivity(new Intent(getActivity(), MakeOrderActivity.class));
//        Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();
    }
}
