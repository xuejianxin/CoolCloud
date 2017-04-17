package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/3/7.
 */

public class LoadingActivity extends Activity {

    //延迟3秒 1600
    private static final long SPLASH_DELAY_MILLIS = 1100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_loading);

        // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
        new Handler().postDelayed(new Runnable() {
            public void run() {
                goHome();
            }
        }, SPLASH_DELAY_MILLIS);
    }

    private void goHome() {
        Intent intent = new Intent(LoadingActivity.this, MainActivity.class);

        LoadingActivity.this.startActivity(intent);
        LoadingActivity.this.finish();
    }
}
