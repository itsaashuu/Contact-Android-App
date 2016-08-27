package com.example.ashutosh.contacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Social extends Fragment {

    EditText nickname,intro,fb,twitter,insta;
    public Social() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_social, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    private void initialize() {
        nickname = (EditText)getActivity().findViewById(R.id.NickName);
        intro= (EditText)getActivity().findViewById(R.id.BriefIntro);
        fb= (EditText)getActivity().findViewById(R.id.fb);
        twitter= (EditText)getActivity().findViewById(R.id.twitter);
        insta= (EditText)getActivity().findViewById(R.id.Instagram);
    }

    public String getNickName(){
        if(nickname.getText().toString()!=null)
            return nickname.getText().toString();
        else
            return "";
    }

    public String getIntro(){
        if(intro.getText().toString()!=null)
            return intro.getText().toString();
        else
            return "";
    }

    public String getFb(){
        if(fb.getText().toString()!=null)
            return fb.getText().toString();
        else
            return "";
    }

    public String getTwitter(){
        if(twitter.getText().toString()!=null)
            return twitter.getText().toString();
        else
            return "";
    }

    public String getInsta(){
        if(insta.getText().toString()!=null)
            return insta.getText().toString();
        else
            return "";
    }
}
