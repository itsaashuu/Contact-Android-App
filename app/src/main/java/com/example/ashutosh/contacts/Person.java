package com.example.ashutosh.contacts;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by ashutosh on 20/6/16.
 */
public class Person implements Serializable{
    private String name,lastname,phoneNumber,email,dob,company,title,IM,website,officeAddress,nickname,briefintro,fb,twitter,instagram;
    private byte[] picture;
    static private int ID=0;
    private int id;

    Person(String name, String lastname, String phoneNumber,String email, String dob, byte[] picture , String company, String title, String IM, String website,String officeAddress, String nickname,String briefintro,String fb, String twitter, String instagram){
        ID++;
        Log.d("TAG", "ID : "+String.valueOf(ID));
        setName(name);
        setLastname(lastname);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setDob(dob);
        setPicture(picture);
        setCompany(company);
        setTitle(title);
        setIM(IM);
        setWebsite(website);
        setOfficeAddress(officeAddress);
        setNickname(nickname);
        setBriefintro(briefintro);
        setFb(fb);
        setTwitter(twitter);
        setInstagram(instagram);
    }

    Person(int id,String name, String lastname, String phoneNumber,String email, String dob, String company, String title, String IM, String website,String officeAddress, String nickname,String briefintro,String fb, String twitter, String instagram){
        this.id = id;
        Log.d("TAG", "ID : "+String.valueOf(id));
        setName(name);
        setLastname(lastname);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setDob(dob);
        setCompany(company);
        setTitle(title);
        setIM(IM);
        setWebsite(website);
        setOfficeAddress(officeAddress);
        setNickname(nickname);
        setBriefintro(briefintro);
        setFb(fb);
        setTwitter(twitter);
        setInstagram(instagram);
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public int getID(){
        return ID;
    }

    public String getBriefintro() {
        return briefintro;
    }

    public void setBriefintro(String briefintro) {
        this.briefintro = briefintro;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return name+" "+phoneNumber;
    }

    public void setPicture(byte[] b){
        this.picture = b;
    }

    public byte[] getPicture() {
        return picture;
    }
}
