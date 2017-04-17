package com.androxue.coolcloud.info;

/**
 * Created by JimCharles on 2017/4/9.
 */

public class BMusic {
    private String name;

    private int id;

    private int size;

    private String extension;

    private int sr;

    private int dfsId;

    private int bitrate;

    private int playTime;

    private double volumeDelta;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setExtension(String extension){
        this.extension = extension;
    }
    public String getExtension(){
        return this.extension;
    }
    public void setSr(int sr){
        this.sr = sr;
    }
    public int getSr(){
        return this.sr;
    }
    public void setDfsId(int dfsId){
        this.dfsId = dfsId;
    }
    public int getDfsId(){
        return this.dfsId;
    }
    public void setBitrate(int bitrate){
        this.bitrate = bitrate;
    }
    public int getBitrate(){
        return this.bitrate;
    }
    public void setPlayTime(int playTime){
        this.playTime = playTime;
    }
    public int getPlayTime(){
        return this.playTime;
    }
    public void setVolumeDelta(double volumeDelta){
        this.volumeDelta = volumeDelta;
    }
    public double getVolumeDelta(){
        return this.volumeDelta;
    }

}
