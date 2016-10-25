package com.qf.besttravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qfkf.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by zhoudan on 2016/10/8.
 */
public class LookPlanWebActivity extends BaseActivity {
    @Bind(R.id.travel_map_days_title)
    TextView travelMapDaysTitle;
    @Bind(R.id.scenery_web_back)
    ImageView sceneryWebBack;
    @Bind(R.id.scenery_web_mapguide)
    ImageView sceneryWebMapguide;
    @Bind(R.id.scenery_web_share)
    ImageView sceneryWebShare;
    @Bind(R.id.scenery_web_rela)
    RelativeLayout sceneryWebRela;
    private WebView web_straandtrev;
    private String web_url;

    @Override
    public int getContentViewId() {
        return R.layout.activity_lookplan_web;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        web_url = intent.getStringExtra("web_url");
        web_straandtrev = (WebView) findViewById(R.id.web_straandtrev);
        web_straandtrev.getSettings().setJavaScriptEnabled(true);
        web_straandtrev.getSettings().setDomStorageEnabled(true);
        web_straandtrev.getSettings().setDefaultTextEncodingName("utf-8");
        web_straandtrev.getSettings().setDefaultFontSize(18);
        web_straandtrev.getSettings().setFixedFontFamily("微软雅黑");
        web_straandtrev.getSettings().setLoadWithOverviewMode(true);
        web_straandtrev.getSettings().setUseWideViewPort(true);

        web_straandtrev.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(web_url);
                return true;
            }
        });
        web_straandtrev.loadUrl(web_url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //按下返回键
            if (web_straandtrev.canGoBack()) {
                //返回webview
                web_straandtrev.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.scenery_web_back, R.id.scenery_web_mapguide, R.id.scenery_web_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scenery_web_back:
                finish();
                break;
            case R.id.scenery_web_mapguide:
                break;
            case R.id.scenery_web_share:
                showShare();
                break;
        }
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.icon_guide_headimg, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        /**
//         * web.canGoBack()判断webview是否有可以返回的页面
//         */
//        if (keyCode == KeyEvent.KEYCODE_BACK && web_straandtrev.canGoBack()) { //判断是否点击返回按钮，并且webview有返回界面
//            web_straandtrev.goBack();   //让webview返回到它的上一个页面
//            return true;   //返回按钮有效
//        } else if (keyCode == KeyEvent.KEYCODE_BACK && (!web_straandtrev.canGoBack())) { //只是判断是否点击了返回按钮
//            //弹出是否要退出该app的对话框
//            AlertDialog dialog = new AlertDialog.Builder(this)
//                    .setMessage("确定要退出吗？")
//                    .setIcon(R.mipmap.icon_guide_headimg)
//                    .setTitle("提示")
//                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            finish();   //关闭当前的页面
//                            System.exit(0);//完全退出该app
//                        }
//                    })
//                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    })
//                    .create();
//            dialog.show();
//            return true;
//        }
//        return false;   //返回键没有反应
//    }

}
