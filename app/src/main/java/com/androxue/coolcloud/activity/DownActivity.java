package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/3/30.
 */

public class DownActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_down);
    }
}
