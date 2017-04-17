package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/3/29.
 */

public class PlayingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_playing);

        ImageView play_needle = (ImageView) findViewById(R.id.needle);
        play_needle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView love = (ImageView) findViewById(R.id.playing_fav);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView down = (ImageView) findViewById(R.id.playing_down);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView message = (ImageView) findViewById(R.id.playing_cmt);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView more = (ImageView) findViewById(R.id.playing_more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView last = (ImageView) findViewById(R.id.playing_pre);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView play = (ImageView) findViewById(R.id.playing_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView next = (ImageView) findViewById(R.id.playing_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView list = (ImageView) findViewById(R.id.playing_playlist);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
