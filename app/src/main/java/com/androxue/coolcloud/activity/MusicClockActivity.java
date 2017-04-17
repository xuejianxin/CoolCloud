package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextClock;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/3/15.
 */

public class MusicClockActivity extends Activity {

    private TextClock textClock;

    @Override
    protected void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_music_clock);

        textClock = (TextClock) findViewById(R.id.clock);
        // 设置12时制显示格式
        textClock.setFormat12Hour("EEEE, MMMM dd, yyyy h:mmaa");
        // 设置24时制显示格式
        textClock.setFormat24Hour("yyyy-MM-dd hh:mm, EEEE");

        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
