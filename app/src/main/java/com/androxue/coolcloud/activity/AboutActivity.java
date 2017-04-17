package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.androxue.coolcloud.R;

/**
 * Created by JimCharles on 2017/3/11.
 */

public class AboutActivity extends Activity {

    private ImageView back;
    private TextView csdn, blog, github, zhihu;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        csdn = (TextView) findViewById(R.id.csdn);
        csdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://blog.csdn.net/jim__charles"));
                startActivity(intent);
            }
        });

        blog = (TextView) findViewById(R.id.blog);
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://xuejianxin.xyz"));
                startActivity(intent);
            }
        });

        github = (TextView) findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/xuejianxin"));
                startActivity(intent);
            }
        });

        zhihu = (TextView) findViewById(R.id.zhihu);
        zhihu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.zhihu.com/people/jim-charles-56/pins/posts"));
                startActivity(intent);
            }
        });
    }

}
