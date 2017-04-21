package com.androxue.coolcloud.util;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

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
 * Created by JimCharles on 2017/3/28.
 */

public class HttpUtils extends Activity {

    private String mp3Url, result = "";
    MediaPlayer mediaPlayer = null;

    public boolean sendHttpPostRequest(String request) throws IOException {
        HttpURLConnection connection = null;
        try{
            String httpUrl = "http://music.163.com/api/search/pc/";
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            //设置http请求方法
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");//设置请求方式为post
            connection.setReadTimeout(5000);//设置读取超时为5秒
            connection.setConnectTimeout(10000);//设置连接超时为10秒
            //设置请求头，包括Cookie、refer、Charset
            connection.setRequestProperty("os", "pc");
            connection.setRequestProperty("MUSIC_U", "5339640232");
            connection.setRequestProperty("Charset", "utf-8");
            //进行连接
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            //请求参数
            String data = "&s=" + URLEncoder.encode(request, "UTF-8")+ "&limit=" + URLEncoder.encode("1", "UTF-8")+ "&type="
                    + URLEncoder.encode("1", "UTF-8") + "&offset" + URLEncoder.encode("0", "UTF-8") + "&total=" + URLEncoder.encode("true", "UTF-8");
            //通过EdirText获取输入内容进行搜索；因为手机屏幕原因，将搜索返回数目控制为10条；搜索形式为单曲搜索；偏移量设置为0，即不进行偏移

            //获取输出流
            out.writeBytes(data);
            out.flush();
            out.close();
            //获取响应输入流对象
            if (connection.getResponseCode() == 200) {
                InputStreamReader is = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(is);
                StringBuilder strBuffer = new StringBuilder();
                String line;
                //读取服务器返回信息
                while ((line = bufferedReader.readLine()) != null){
                    strBuffer.append(line);
                }
                result = strBuffer.toString();
                bufferedReader.close();
                is.close();
            }
        }catch (IOException e) {
            return true;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return false;
    }

    public void parseJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject result = jsonObject.getJSONObject("result");
        JSONArray jsonArray = result.getJSONArray("songs");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            mp3Url = jsonObject1.getString("mp3Url");
        }
    }

    private void search() {
                final Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        try {
                            parseJson(result);
                            playMusic();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (msg.what == 1) {
                            //提示读取结果
                            Toast.makeText(HttpUtils.this, result, Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                new Thread() {
                    public void run() {
                        //请求网络
                        try {
                            sendHttpPostRequest("");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Message m = new Message();
                        m.what = 1;
                        // 发送消息到Handler
                        handler.sendMessage(m);
                    }
                }.start();
    }

    public void playMusic() {
        mediaPlayer = MediaPlayer.create(this, Uri.parse(mp3Url));
        mediaPlayer.start();
    }
}
