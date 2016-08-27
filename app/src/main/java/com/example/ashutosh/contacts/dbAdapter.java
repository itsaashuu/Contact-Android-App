package com.example.ashutosh.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ashutosh on 23/6/16.
 */
public class dbAdapter {


    dbHelper helper;

    dbAdapter(Context context) {
        helper = new dbHelper(context, null, null, 1);
    }

    public long addPerson(Person p){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Log.d("TAG", "Inside Add Person : " + p.getName());
        cv.put(dbHelper.NAME, p.getName());
        cv.put(dbHelper.LASTNAME,p.getLastname());
        cv.put(dbHelper.PHONE_NUMBER,p.getPhoneNumber());
        cv.put(dbHelper.EMAIL,p.getEmail());
        cv.put(dbHelper.DOB,p.getDob());
        cv.put(dbHelper.PICTURE,p.getPicture());
        cv.put(dbHelper.COMPANY,p.getCompany());
        cv.put(dbHelper.TITLE,p.getTitle());
        cv.put(dbHelper.IM,p.getIM());
        cv.put(dbHelper.WEBSITE,p.getWebsite());
        cv.put(dbHelper.OFFICE_ADDRESS,p.getOfficeAddress());
        cv.put(dbHelper.BRIEF_INTRO,p.getBriefintro());
        cv.put(dbHelper.NICK_NAME,p.getNickname());
        cv.put(dbHelper.FB,p.getFb());
        cv.put(dbHelper.TWITTER,p.getTwitter());
        cv.put(dbHelper.INSTAGRAM,p.getInstagram());
        long id= db.insert(dbHelper.TABLE_NAME,dbHelper.NAME,cv);
        db.close();
        return id;
    }

    public ArrayList<Person> getPersons(String sort, boolean way){
        ArrayList<Person> persons = new ArrayList<Person>();
        SQLiteDatabase db = helper.getWritableDatabase();
        String query;
        if(way==true)
            query = "SELECT * FROM " + dbHelper.TABLE_NAME + " WHERE 1"+" ORDER BY "+ dbHelper.NAME + " "+sort;
        else
            query = "SELECT * FROM " + dbHelper.TABLE_NAME + " WHERE 1"+" ORDER BY "+ dbHelper.LASTNAME + " "+sort;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        try {
            while (!c.isAfterLast()) {
                if (c.getString(c.getColumnIndex(dbHelper.NAME)) != null) {
                    Log.d("TAG", "Inside Cursor IF");
                        Person person = new Person(c.getString(c.getColumnIndex(dbHelper.NAME)),c.getString(c.getColumnIndex(dbHelper.LASTNAME)),c.getString(c.getColumnIndex(dbHelper.PHONE_NUMBER)),
                            c.getString(c.getColumnIndex(dbHelper.EMAIL)),c.getString(c.getColumnIndex(dbHelper.DOB)),c.getBlob(c.getColumnIndex(dbHelper.PICTURE)) ,c.getString(c.getColumnIndex(dbHelper.COMPANY)),c.getString(c.getColumnIndex(dbHelper.TITLE)),
                            c.getString(c.getColumnIndex(dbHelper.IM)),c.getString(c.getColumnIndex(dbHelper.WEBSITE)),c.getString(c.getColumnIndex(dbHelper.OFFICE_ADDRESS)),c.getString(c.getColumnIndex(dbHelper.NICK_NAME)),
                            c.getString(c.getColumnIndex(dbHelper.BRIEF_INTRO)),c.getString(c.getColumnIndex(dbHelper.FB)),c.getString(c.getColumnIndex(dbHelper.TWITTER)),c.getString(c.getColumnIndex(dbHelper.INSTAGRAM)));
                    Log.d("TAG", String.valueOf(person));
                    persons.add(person);
                }
                c.moveToNext();
            }
        }catch (Exception e){

        }
        db.close();
        Log.d("TAG","INSIDE ARRAY LIST : "+ String.valueOf(persons.size()));
        return persons;
    }

    public String searchNumber(String phoneNumber){
        if(phoneNumber.contains("*")||phoneNumber.contains("#"))
            return "Unknown";
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        String name="";
        String query = "SELECT "+ dbHelper.NAME+" FROM " + dbHelper.TABLE_NAME + " WHERE phoneNumber = " +phoneNumber;
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        c.moveToFirst();
        try{
            while(!c.isAfterLast()){
                if(c.getString(c.getColumnIndex(dbHelper.NAME))!=null){
                    name= c.getString(c.getColumnIndex(dbHelper.NAME));
                }
            }
        }catch (Exception e){

        }
        return name;
    }

    public byte[] searchImage(String phoneNumber){
        if(phoneNumber.contains("*")||phoneNumber.contains("#"))
            return null;
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        byte[] image = null;
        String query = "SELECT picture FROM " + dbHelper.TABLE_NAME + " WHERE phoneNumber = " +phoneNumber;
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        c.moveToFirst();
        try{
            while(!c.isAfterLast()){
                if(c.getBlob(c.getColumnIndex(dbHelper.PICTURE))!=null){
                    image= c.getBlob(c.getColumnIndex(dbHelper.PICTURE));
                }
            }
        }catch (Exception e){

        }
        return image;
    }


    class dbHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME="contacts.db";
        private static final int DATABASE_VERSION=4;
        private static final String TABLE_NAME="table_contact";

        private static final String NAME="name";
        private static final String PHONE_NUMBER="phoneNumber";
        private static final String LASTNAME="lastName";
        private static final String EMAIL="email";
        private static final String DOB="dob";
        private static final String COMPANY="company";
        private static final String TITLE="title";
        private static final String IM="IM";
        private static final String WEBSITE="website";
        private static final String OFFICE_ADDRESS="officeAdd";
        private static final String BRIEF_INTRO="bIntro";
        private static final String NICK_NAME="nickname";
        private static final String FB="fb";
        private static final String TWITTER="twitter";
        private static final String INSTAGRAM="instagram";
        private static final String PICTURE="picture";
        private static final String ID="id";
        Context context;


        public dbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE "+TABLE_NAME+" ( " +
                    NAME+" TEXT, "+
                    LASTNAME+" TEXT, "+
                    PHONE_NUMBER+" TEXT,"+
                    EMAIL+" TEXT, "+
                    DOB+" TEXT, "+
                    PICTURE+" BLOB, "+
                    COMPANY+" TEXT, "+
                    TITLE+" TEXT, "+
                    IM+" TEXT, "+
                    WEBSITE+" TEXT, "+
                    OFFICE_ADDRESS+" TEXT, "+
                    BRIEF_INTRO+" TEXT, "+
                    NICK_NAME+" TEXT, "+
                    FB+" TEXT, "+
                    TWITTER+" TEXT, "+
                    INSTAGRAM+" TEXT "+
                    ");";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }
    }

}

