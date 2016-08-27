package com.example.ashutosh.contacts;

/**
 * Created by ashutosh on 19/7/16.
 */
public class SingleLog {
    private String name,phone,type,date,duration;
    private byte[] image;

    SingleLog(){

    }

    SingleLog(String name, String phone,String type, String date, String duration, byte[] image){
        setName(name);
        setName(phone);
        setType(type);
        setImage(image);
        setDuration(duration);
        setDate(date);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration(){
        return this.duration;
    }
}
