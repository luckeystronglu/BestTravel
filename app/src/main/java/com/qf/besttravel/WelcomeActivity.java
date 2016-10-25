package com.qf.besttravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ImageView;

import com.qfkf.base.BaseActivity;


/**
 * Created by lenovo on 2016/9/26.
 */
public class WelcomeActivity extends BaseActivity {
    private SharedPreferences sp;
    private boolean isFirst;

    private ImageView imageView;

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init() {
        sp = getSharedPreferences("luckey",MODE_PRIVATE);
        isFirst = sp.getBoolean("First",true);
        imageView = findViewByIds(R.id.iv_welcomme);
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirst){
                    sp.edit().putBoolean("First",false).commit();
                    startActivity(new Intent(WelcomeActivity.this,MediaInfoActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                    finish();
                }
//                startActivityForAnimation(new Intent(WelcomeActivity.this,MainActivity.class),
//                        R.anim.anim_wel_bottom_in,R.anim.amin_wel_quiet);
//                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
//                finish();
            }
        },1500);
    }

}
