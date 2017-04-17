package com.androxue.coolcloud.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androxue.coolcloud.R;
import com.androxue.coolcloud.handler.HandlerUtil;
import com.androxue.coolcloud.info.Info;
import com.androxue.coolcloud.widget.CycleViewPager;
import com.androxue.coolcloud.widget.SplashScreen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
                implements NavigationView.OnNavigationItemSelectedListener {

    List<Info> mList = new ArrayList<>();   //模拟请求后得到的数据
    CycleViewPager mCycleViewPager; //轮播图

    private long time = 0;
    private SplashScreen splashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        splashScreen = new SplashScreen(this);
        splashScreen.show(R.drawable.art_login_bg,
                SplashScreen.SLIDE_LEFT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView barnet = (ImageView) findViewById(R.id.bar_net);
        barnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, .class);
//                startActivity(intent);
            }
        });

        ImageView barmusic = (ImageView) findViewById(R.id.bar_music);
        barmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(intent);
            }
        });

        ImageView barfriends = (ImageView) findViewById(R.id.bar_friends);
        barfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(intent);
            }
        });

        ImageView search = (ImageView) findViewById(R.id.bar_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        TextView cloudmusic = (TextView) findViewById(R.id.clooud_music);
        cloudmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://music.163.com/m/user/home?id=2082221\n"));
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HandlerUtil.getInstance(this).postDelayed(new Runnable() {
            @Override
            public void run() {
                splashScreen.removeSplashScreen();
            }
        }, 1000);

        initData();
        initView();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Setting is still undefinde", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
            //我的消息
            Intent intent = new Intent(MainActivity.this, MessageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_friend){
            //我的好友
            Intent intent = new Intent(MainActivity.this, FriendActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            //个性换肤
        } else if (id == R.id.nav_slideshow) {
            //夜间模式
            SharedPreferences sp = this.getSharedPreferences("loonggg", MODE_PRIVATE);
            boolean isNight = sp.getBoolean("night", false);
            if (isNight) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                sp.edit().putBoolean("night", false).apply();
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                sp.edit().putBoolean("night", true).apply();
            }
            recreate();
        } else if (id == R.id.nav_manage) {
//            toWeChatScan();//调用微信扫一扫
            toAliPayScan();//调用支付宝扫一扫
//            Intent intent = new Intent(MainActivity.this, ScanActivity.class);
//            startActivity(intent);
        } else if (id == R.id.nav_share) {
            //音乐云盘
            Intent intent = new Intent(MainActivity.this, MusicCloudActivity.class);
            startActivity(intent);
        } else if (id == R.id.clock){
            //音乐闹钟
            Intent intent = new Intent(MainActivity.this, MusicClockActivity.class);
            startActivity(intent);
        } else if (id == R.id.drive) {
            //驾驶模式
            Intent intent = new Intent(MainActivity.this, DriveActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            //关于
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_exit){
            //退出
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 双击返回桌面
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - time > 1000)) {
                Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            } else {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.onRequestPermissionsResult(requestCode,permissions,grantResults);
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashScreen.removeSplashScreen();
    }

    private void toWeChatScan() {
        try {
            //利用Intent打开微信
            Uri uri = Uri.parse("weixin://dl/scan");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            //若无法正常跳转，在此进行错误处理
            Toast.makeText(this, "无法跳转到微信，请检查您是否安装了微信！", Toast.LENGTH_SHORT).show();
        }
    }

    private void toAliPayScan() {
        try {
            //利用Intent打开支付宝
            //支付宝跳过开启动画打开扫码和付款码的url scheme分别是alipayqr://platformapi/startapp?saId=10000007和
            //alipayqr://platformapi/startapp?saId=20000056
            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            //若无法正常跳转，在此进行错误处理
            Toast.makeText(this, "无法跳转到支付宝，请检查您是否安装了支付宝！", Toast.LENGTH_SHORT).show();
        }
    }

    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(Info info, int position, View imageView) {

            if (mCycleViewPager.isCycle()) {
                position = position - 1;
            }
            Toast.makeText(MainActivity.this, info.getTitle() + "was clicked" + position, Toast.LENGTH_LONG).show();
        }
    };

    /**
     * 初始化Data
     */
    private void initData() {
        mList.add(new Info("Beautiful Girl", "http://img2.3lian.com/2014/c7/25/d/40.jpg"));
        mList.add(new Info("Lovely Girl", "http://img2.3lian.com/2014/c7/25/d/41.jpg"));
        mList.add(new Info("Sunny Girl", "http://imgsrc.baidu.com/forum/pic/item/b64543a98226cffc8872e00cb9014a90f603ea30.jpg"));
        mList.add(new Info("Listing Girl", "http://imgsrc.baidu.com/forum/pic/item/261bee0a19d8bc3e6db92913828ba61eaad345d4.jpg"));
    }

    /**
     * 初始化View
     */
    private void initView() {
        mCycleViewPager = (CycleViewPager) findViewById(R.id.cycle_view);
        //设置选中和未选中时的图片
        assert mCycleViewPager != null;
        mCycleViewPager.setIndicators(R.mipmap.ad_select, R.mipmap.ad_unselect);
        //设置轮播间隔时间，默认为4000
        mCycleViewPager.setDelay(4000); //4s
        mCycleViewPager.setData(mList, mAdCycleViewListener);
    }

    public static View getImageView(Context context, String url) {
        RelativeLayout rl = new RelativeLayout(context);
        //添加一个ImageView，并加载图片
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        //使用Picasso来加载图片
        Picasso.with(context).load(url).into(imageView);
        //在Imageview前添加一个半透明的黑色背景，防止文字和图片混在一起
        ImageView backGround = new ImageView(context);
        backGround.setLayoutParams(layoutParams);
        backGround.setBackgroundResource(R.color.cycle_image_bg);
        rl.addView(imageView);
        rl.addView(backGround);
        return rl;
    }
}
