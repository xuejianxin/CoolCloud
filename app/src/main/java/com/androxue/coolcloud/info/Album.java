package com.androxue.coolcloud.info;

import java.util.List;

/**
 * Created by JimCharles on 2017/4/9.
 */

public class Album {
    private String name;

    private int id;

    private String type;

    private int size;

    private int picId;

    private String blurPicUrl;

    private int companyId;

    private int pic;

    private String picUrl;

    private int publishTime;

    private String description;

    private String tags;

    private String company;

    private String briefDesc;

    private Artist artist;

    private List<Songs> songs ;

    private List<String> alias ;

    private int status;

    private int copyrightId;

    private String commentThreadId;

    private List<Artists> artists ;

    private String picId_str;

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
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setPicId(int picId){
        this.picId = picId;
    }
    public int getPicId(){
        return this.picId;
    }
    public void setBlurPicUrl(String blurPicUrl){
        this.blurPicUrl = blurPicUrl;
    }
    public String getBlurPicUrl(){
        return this.blurPicUrl;
    }
    public void setCompanyId(int companyId){
        this.companyId = companyId;
    }
    public int getCompanyId(){
        return this.companyId;
    }
    public void setPic(int pic){
        this.pic = pic;
    }
    public int getPic(){
        return this.pic;
    }
    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }
    public String getPicUrl(){
        return this.picUrl;
    }
    public void setPublishTime(int publishTime){
        this.publishTime = publishTime;
    }
    public int getPublishTime(){
        return this.publishTime;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setTags(String tags){
        this.tags = tags;
    }
    public String getTags(){
        return this.tags;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public String getCompany(){
        return this.company;
    }
    public void setBriefDesc(String briefDesc){
        this.briefDesc = briefDesc;
    }
    public String getBriefDesc(){
        return this.briefDesc;
    }
    public void setArtist(Artist artist){
        this.artist = artist;
    }
    public Artist getArtist(){
        return this.artist;
    }
    public void setSongs(List<Songs> songs){
        this.songs = songs;
    }
    public List<Songs> getSongs(){
        return this.songs;
    }
    public void setString(List<String> alias){
        this.alias = alias;
    }
    public List<String> getString(){
        return this.alias;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setCopyrightId(int copyrightId){
        this.copyrightId = copyrightId;
    }
    public int getCopyrightId(){
        return this.copyrightId;
    }
    public void setCommentThreadId(String commentThreadId){
        this.commentThreadId = commentThreadId;
    }
    public String getCommentThreadId(){
        return this.commentThreadId;
    }
    public void setArtists(List<Artists> artists){
        this.artists = artists;
    }
    public List<Artists> getArtists(){
        return this.artists;
    }
    public void setPicId_str(String picId_str){
        this.picId_str = picId_str;
    }
    public String getPicId_str(){
        return this.picId_str;
    }

}
