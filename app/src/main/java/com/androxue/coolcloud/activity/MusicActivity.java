package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/3/14.
 */

public class MusicActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ImageView draw = (ImageView) findViewById(R.id.draw);
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView search = (ImageView) findViewById(R.id.bar_search) ;
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        ImageView barnet = (ImageView) findViewById(R.id.bar_net);
        barnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView barmusic = (ImageView) findViewById(R.id.bar_music);
        barmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView barfriend = (ImageView) findViewById(R.id.bar_music);
        barfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
