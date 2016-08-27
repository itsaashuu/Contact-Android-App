package com.example.ashutosh.contacts;


import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllContacts extends Fragment implements AdapterView.OnItemClickListener,Serializable, AdapterView.OnItemLongClickListener {

    dbAdapter db;
    ListView lv;
    View rootView;
    ArrayList<Person> persons;
    String sort;
    boolean way;

    public AllContacts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_all_contacts, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("TAG", "onActivity");
        db = new dbAdapter(getActivity());
        lv = (ListView) rootView.findViewById(R.id.allCLv);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        sort =  sharedPreferences.getString("list_preferences", "ASC");
        way = sharedPreferences.getBoolean("checkbox", true);
        Toast.makeText(getActivity(),sort+" "+way,Toast.LENGTH_LONG).show();
        persons = db.getPersons(sort,way);

        Log.d("TAG", String.valueOf(persons.size()));

        CustomAdapter customAdapter = new CustomAdapter(getContext(),persons,way);

        lv.setAdapter(customAdapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayList<Person> persons = db.getPersons(sort,way);
        Log.d("TAG", String.valueOf(persons.size()));
        CustomAdapter customAdapter = new CustomAdapter(getContext(),persons,way);
        lv.setAdapter(customAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(),SingleContact.class);
        Person obj = persons.get(position);
        i.putExtra("contact", obj);
        Log.d("TAG","SAb Sahi Hein");
        startActivity(i);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),persons.get(position).getPhoneNumber(),Toast.LENGTH_LONG).show();
        return true;
    }
}
