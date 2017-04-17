package com.androxue.coolcloud.util;

/**
 * Created by JimCharles on 2017/3/29.
 */

public interface IConstants {

    String MUSIC_COUNT_CHANGED = "com.androxue.coolcloud.musiccountchanged";
    String PLAYLIST_ITEM_MOVED = "com.androxue.coolcloud.mmoved";
    String PLAYLIST_COUNT_CHANGED = "com.androxue.coolcloud.playlistcountchanged";
    String CHANGE_THEME = "com.androxue.coolcloud.themechange";
    String EMPTY_LIST = "com.androxue.coolcloud.emptyplaylist";
    String PACKAGE = "com.androxue.coolcloud";
    int MUSICOVERFLOW = 0;
    int ARTISTOVERFLOW = 1;
    int ALBUMOVERFLOW = 2;
    int FOLDEROVERFLOW = 3;

    //歌手和专辑列表点击都会进入MyMusic 此时要传递参数表明是从哪里进入的
    int START_FROM_ARTIST = 1;
    int START_FROM_ALBUM = 2;
    int START_FROM_LOCAL = 3;
    int START_FROM_FOLDER = 4;
    int START_FROM_FAVORITE = 5;

    int FAV_PLAYLIST = 10;


    String NAVIGATE_NOWPLAYING = "navigate_nowplaying";
}
