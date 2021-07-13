package com.example.myapplicationtest.ui.home;

public class NewNotic {

    private int photoImage;
    private String name;
    private String note;
    private String time;
    private String week;
    private String dd;

    public NewNotic(){

    }

    //大頭照
    public void setPhotoImage(int image){
        this.photoImage = image;
    }

    public int getPhotoImage(){
        return photoImage;
    }

    //姓名
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    //訊息
    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return note;
    }

    //時間
    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    //星期幾
    public void setWeek(String week){
        this.week = week;
    }

    public String getWeek(){
        return week;
    }

    //日
    public void setDD(String dd){
        this.dd = dd;
    }

    public String getDD(){
        return dd;
    }

}
