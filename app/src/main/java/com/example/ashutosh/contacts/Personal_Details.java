package com.example.ashutosh.contacts;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class Personal_Details extends Fragment implements View.OnClickListener {

    EditText name, lastname, phoneNumber,email,dob;
    Button changeImage;
    ImageView imagePerson;
    int requestCode = 1;
    Bitmap mBmp;
    public Personal_Details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal__details, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    private void initialize() {
        name= (EditText)getActivity().findViewById(R.id.name);
        lastname= (EditText)getActivity().findViewById(R.id.lastName);
        phoneNumber= (EditText)getActivity().findViewById(R.id.phoneNumber);
        email= (EditText)getActivity().findViewById(R.id.emailAddress);
        dob= (EditText)getActivity().findViewById(R.id.DOB);
        changeImage = (Button)getActivity().findViewById(R.id.buttonCImage);
        imagePerson = (ImageView)getActivity().findViewById(R.id.imagePerson);
        changeImage.setOnClickListener(this);
        InputStream is = (InputStream) getActivity().getResources().openRawResource(+ R.drawable.anonymous);
        mBmp = BitmapFactory.decodeStream(is);
    }

    public String getName(){
        if(name.getText().toString()!=null)
            return name.getText().toString();
        else
            return "";
    }

    public String getLastName(){
        if(lastname.getText().toString()!=null)
            return lastname.getText().toString();
        else
            return "";
    }

    public String getEmail(){
        if(email.getText().toString()!=null)
            return email.getText().toString();
        else
            return "";
    }

    public String getPhone(){
        if(phoneNumber.getText().toString()!=null)
            return phoneNumber.getText().toString();
        else
            return "";
    }

    public String getDOB(){
        if(dob.getText().toString()!=null)
            return dob.getText().toString();
        else
            return "";
    }

    public byte[] getImage(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        mBmp.compress(Bitmap.CompressFormat.PNG,0,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onClick(View v) {
        Intent pic = new Intent(Intent.ACTION_GET_CONTENT);
        pic.setType("image/*");
        startActivityForResult(pic, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                Uri chosenImageUri = data.getData();
                try {
                    mBmp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),chosenImageUri);
                    imagePerson.setImageBitmap(mBmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
