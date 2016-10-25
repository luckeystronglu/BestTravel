package com.qf.besttravel;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.qfkf.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2016/10/5.
 */
public class SearchActivity extends BaseActivity {
    @Bind(R.id.search_img_back)
    ImageView searchImgBack;
    @Bind(R.id.search_edit)
    EditText searchEdit;
    @Bind(R.id.search_clear)
    ImageView searchClear;

    @Override
    public int getContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.search_img_back, R.id.search_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_img_back:
                finish();
                break;
            case R.id.search_clear:

                break;
        }
    }
}
