package com.androxue.coolcloud.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.androxue.coolcloud.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by JimCharles on 2017/3/30.
 */

public class DownActivity extends Activity {

    String songName, result = "";
    int songId;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_down);
    }

    public boolean sendHttpPostRequest() throws IOException {
        try{
            String httpUrl = "http://music.163.com/api/search/get/";
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置http请求方法
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");//设置请求方式为post
            connection.setConnectTimeout(10000);//设置超时为10秒
            //设置请求头，包括Cookie、refer、Charset
            connection.setRequestProperty("Cookie", "appver=2.0.2");
            connection.setRequestProperty("refer", "http://music.163.com ");
            connection.setRequestProperty("Charset", "utf-8");
            //进行连接
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            //请求参数
            String id = Integer.toString(songId);
            String data = "&s=" + URLEncoder.encode(id, "UTF-8")+ "&limit=" + URLEncoder.encode("10", "UTF-8")+ "&type="
                    + URLEncoder.encode("1", "UTF-8") + "&offset" + URLEncoder.encode("0", "UTF-8");
            //通过EdirText获取输入内容进行搜索；因为手机屏幕原因，将搜索返回数目控制为10条；搜索形式为单曲搜索；偏移量设置为0，即不进行偏移

            //获取输出流zze
            out.writeBytes(data);
            out.flush();
            out.close();
            //获取响应输入流对象
            if (connection.getResponseCode() == 200) {
                InputStreamReader is = new InputStreamReader(connection.getInputStream());

                JSONArray jsonArray = new JSONArray(is);
                for (int i = 0; i < 1;i++) {
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    songName = jsonObject.optString("name");
                    songId = jsonObject.optInt("id");
                }
                BufferedReader bufferedReader = new BufferedReader(is);
                StringBuilder strBuffer = new StringBuilder();
                String line;
                //读取服务器返回信息
                while ((line = bufferedReader.readLine()) != null){
                    strBuffer.append(line);
                }
                result = strBuffer.toString();
                is.close();
                connection.disconnect();
            }
        }catch (IOException e) {
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

//    private void search(){
//        fatherspoetry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Handler handler = new Handler() {
//                    @Override
//                    public void handleMessage(Message msg) {
//                        if (msg.what == 1) {
//                            //提示读取结果
//                            Toast.makeText(DownActivity.this, result, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                };
//                new Thread() {
//                    public void run() {
//                        //请求网络
//                        try {
//                            sendHttpPostRequest();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        Message m = new Message();
//                        m.what = 1;
//                        // 发送消息到Handler
//                        handler.sendMessage(m);
//                    }
//                }.start();
//            }
//        });
//    }
}
