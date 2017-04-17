package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/4/7.
 */

public class LockActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lock);

        TextView time = (TextView) findViewById(R.id.lock_time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView date = (TextView) findViewById(R.id.lock_date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView music_name = (TextView) findViewById(R.id.lock_music_name);
        music_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView music_artsit = (TextView) findViewById(R.id.lock_music_artsit);
        music_artsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView last = (ImageView) findViewById(R.id.lock_music_pre);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView play = (ImageView) findViewById(R.id.lock_music_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView next = (ImageView) findViewById(R.id.lock_music_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView love = (ImageView) findViewById(R.id.lock_music_fav);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
