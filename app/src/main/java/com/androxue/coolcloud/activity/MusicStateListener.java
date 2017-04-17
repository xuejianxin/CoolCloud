package com.androxue.coolcloud.activity;

/**
 * Created by JimCharles on 2017/3/7.
 */

public interface MusicStateListener {

    /**
     * 更新歌曲状态信息
     */
    void updateTrackInfo();

    void updateTime();

    void changeTheme();

    void reloadAdapter();
}
