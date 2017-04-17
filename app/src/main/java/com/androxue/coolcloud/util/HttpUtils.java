package com.androxue.coolcloud.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Created by JimCharles on 2017/3/28.
 */

public class HttpUtils {

    private String search, result;
    Scanner scanner;

    public boolean sendHttpPostRequest() throws IOException {
        search = scanner.nextLine();
        try{
            String httpUrl = "http://music.163.com/api/search/get/";
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置http请求方法
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");//设置请求方式为post
            connection.setConnectTimeout(3000);//设置超时为3秒
            //设置请求头，包括Cookie、refer、Charset
            connection.setRequestProperty("Cookie", "appver=2.0.2");
            connection.setRequestProperty("refer", "http://music.163.com ");
            connection.setRequestProperty("Charset", "utf-8");
            //进行连接
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            //请求参数
            String data = "&s=" + URLEncoder.encode(search, "UTF-8")+ "&limit=" + URLEncoder.encode("10", "UTF-8")+ "&type="
                    + URLEncoder.encode("1", "UTF-8") + "&offset" + URLEncoder.encode("0", "UTF-8");
            //通过EdirText获取输入内容进行搜索；因为手机屏幕原因，将搜索返回数目控制为10条；搜索形式为单曲搜索；偏移量设置为0，即不进行偏移

            //获取输出流zze
            out.writeBytes(data);
            out.flush();
            out.close();
            //获取响应输入流对象
            InputStreamReader is = new InputStreamReader(connection.getInputStream());
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
        }catch (IOException e) {
            return true;
        }
        return false;
    }
}
