package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/3/14.
 */

public class MusicCloudActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_musiccloud);

        ImageView back = (ImageView) findViewById(R.id.ic_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView search = (ImageView) findViewById(R.id.ic_bar_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicCloudActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        ImageView cloud = (ImageView) findViewById(R.id.cloud);
        cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView goToCloud = (ImageView) findViewById(R.id.go_to_cloud);
        goToCloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
