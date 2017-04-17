package com.androxue.coolcloud.info;

import java.util.List;

/**
 * Created by JimCharles on 2017/4/9.
 */

public class Result {
    private List<Songs> songs ;

    private int songCount;

    public void setSongs(List<Songs> songs){
        this.songs = songs;
    }

    public List<Songs> getSongs(){
        return this.songs;
    }

    public void setSongCount(int songCount){
        this.songCount = songCount;
    }

    public int getSongCount(){
        return this.songCount;
    }

}
