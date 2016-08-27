package com.example.ashutosh.contacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Proffesional_Details extends Fragment {


    EditText companyName,title,IM,officeAdd,website;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proffesional__details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    private void initialize() {
        companyName= (EditText)getActivity().findViewById(R.id.companyName);
        title= (EditText)getActivity().findViewById(R.id.CompanyTitle);
        IM= (EditText)getActivity().findViewById(R.id.IM);
        officeAdd= (EditText)getActivity().findViewById(R.id.OfficeAddress);
        website= (EditText)getActivity().findViewById(R.id.Website);
    }

    public String getCName(){
        if(companyName.getText().toString()!=null)
            return companyName.getText().toString();
        else
            return "";
    }

    public String getTitle(){
        if(title.getText().toString()!=null)
            return title.getText().toString();
        else
            return "";
    }

    public String getIM(){
        if(IM.getText().toString()!=null)
            return IM.getText().toString();
        else
            return "";
    }

    public String getOfficeA(){
        if(officeAdd.getText().toString()!=null)
            return officeAdd.getText().toString();
        else
            return "";
    }

    public String getwebsite(){
        if(website.getText().toString()!=null)
            return website.getText().toString();
        else
            return "";
    }
}
