package com.example.ashutosh.contacts;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ashutosh on 23/6/16.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Person> persons;
    boolean way;
    CustomAdapter(Context context,ArrayList<Person> p,boolean way){
        this.context = context;
        this.persons = p;
        this.way = way;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_item,parent,false);
        CircularImageView imageView = (CircularImageView) row.findViewById(R.id.imageViewCircular);

        Bitmap bitmap = BitmapFactory.decodeByteArray(persons.get(position).getPicture(), 0, persons.get(position).getPicture().length);


        TextView name = (TextView) row.findViewById(R.id.singleCName);
        TextView lastName = (TextView) row.findViewById(R.id.singleLastName);
        TextView phone = (TextView) row.findViewById(R.id.singleBio);

        imageView.setImageBitmap(bitmap);
        if(way) {
            name.setText(persons.get(position).getName() + " ");
            lastName.setText(persons.get(position).getLastname());
        }
        else{
            name.setText(persons.get(position).getLastname() + " ");
            lastName.setText(persons.get(position).getName());

        }
        phone.setText(persons.get(position).getBriefintro());

        return row;
    }
}
