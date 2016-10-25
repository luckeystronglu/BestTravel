package com.qf.besttravel;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.qfkf.base.BaseActivity;

/**
 * Created by lenovo on 2016/10/23.
 */
public class MediaInfoActivity extends BaseActivity{
//    private MediaPlayer mediaPlayer;
    private VideoView videoView;
    private ImageView imageView;
    private LinearLayout ll_media_guide;
    private LinearLayout ll_media_guide2;
    private ImageView enter_app_img;
    private TextView look_media_again;

    @Override
    public int getContentViewId() {
        return R.layout.activity_media;
    }

    @Override
    protected void init() {
        ll_media_guide = findViewByIds(R.id.ll_media_guide);
        ll_media_guide2 = findViewByIds(R.id.ll_media_hind);
        enter_app_img = findViewByIds(R.id.click_enter_app);
        look_media_again = findViewByIds(R.id.tv_look_again);
        videoView = findViewByIds(R.id.guide_videoview);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.media);

        videoView.setMediaController(new MediaController(this)); //设置播放控制器

        imageView = findViewByIds(R.id.icon_mp4_play);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_media_guide.setVisibility(View.GONE);
                videoView.start();

//                if (!videoView.isPlaying()){
//                    ll_media_guide.setVisibility(View.GONE);
//                    videoView.start();
//                }else {
//                    imageView.setVisibility(View.INVISIBLE);
//                    videoView.pause();
//                }

            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ll_media_guide2.setVisibility(View.VISIBLE);
                enter_app_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MediaInfoActivity.this,MainActivity.class));
                        finish();
                    }
                });
                look_media_again.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ll_media_guide.setVisibility(View.GONE);
                        ll_media_guide2.setVisibility(View.GONE);
                        videoView.start();
                    }
                });
            }
        });


    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }
}
