package com.example.ashutosh.contacts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by ashutosh on 19/6/16.
 */
public class FragmentDialler extends Fragment implements View.OnClickListener, View.OnLongClickListener {


    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bp,bd;
    ImageButton delete,call;
    TextView tv;
    Vibrator vibrator;
    SharedPreferences sharedPreferences;
    String string;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialler,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iniatialize();
        setClick();
        setLongClick();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        int check = Integer.parseInt(String.valueOf(preferences.getString("colors", "4")));
        int color = getResources().getColor(R.color.ColorPrimary);
        switch (check){
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 4:
                color = getResources().getColor(R.color.ColorPrimary);
                break;
            case 3:
                color = Color.YELLOW;
                break;
            case 5:
                color = Color.BLACK;
                break;
        }
          b1.setTextColor(color);
            b2.setTextColor(color);
            b3.setTextColor(color);
            b4.setTextColor(color);bp.setTextColor(color);
            b5.setTextColor(color);
            b6.setTextColor(color);
            b7.setTextColor(color);
            b8.setTextColor(color);
            b9.setTextColor(color);
            b0.setTextColor(color);
            bd.setTextColor(color);
            delete.setBackgroundColor(color);
            call.setBackgroundColor(color);

    }

    private void setLongClick() {
        b1.setOnLongClickListener(this);
        b2.setOnLongClickListener(this);
        b3.setOnLongClickListener(this);
        b4.setOnLongClickListener(this);
        b5.setOnLongClickListener(this);
        b6.setOnLongClickListener(this);
        b7.setOnLongClickListener(this);
        b8.setOnLongClickListener(this);
        b9.setOnLongClickListener(this);
        b0.setOnLongClickListener(this);
    }

    private void setClick() {
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bd.setOnClickListener(this);
        bp.setOnClickListener(this);
        delete.setOnClickListener(this);
        call.setOnClickListener(this);
    }



    private void iniatialize() {
        b1 = (Button)getActivity().findViewById(R.id.bone);
        b2 = (Button)getActivity().findViewById(R.id.btwo);
        b3 = (Button)getActivity().findViewById(R.id.bthree);
        b4 = (Button)getActivity().findViewById(R.id.bfour);
        b5 = (Button)getActivity().findViewById(R.id.bfive);
        b6 = (Button)getActivity().findViewById(R.id.bsix);
        b7 = (Button)getActivity().findViewById(R.id.bseven);
        b8 = (Button)getActivity().findViewById(R.id.beight);
        b9 = (Button)getActivity().findViewById(R.id.bnine);
        b0 = (Button)getActivity().findViewById(R.id.bzero);
        bp = (Button)getActivity().findViewById(R.id.bplus);
        bd = (Button)getActivity().findViewById(R.id.bdash);
        delete = (ImageButton) getActivity().findViewById(R.id.fragDiallerIB);
        call = (ImageButton) getActivity().findViewById(R.id.dialbutton);
        tv= (TextView)getActivity().findViewById(R.id.fragDiallerTV);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bone :
                vibrator.vibrate(100);
                tv.append("1");
                break;
            case R.id.btwo :
                vibrator.vibrate(100);
                tv.append("2");
                break;
            case R.id.bthree :
                vibrator.vibrate(100);
                tv.append("3");
                break;
            case R.id.bfour :
                vibrator.vibrate(100);
                tv.append("4");
                break;
            case R.id.bfive :
                vibrator.vibrate(100);
                tv.append("5");
                break;
            case R.id.bsix :
                vibrator.vibrate(100);
                tv.append("6");
                break;
            case R.id.bseven :
                vibrator.vibrate(100);
                tv.append("7");
                break;
            case R.id.beight :
                vibrator.vibrate(100);
                tv.append("8");
                break;
            case R.id.bnine :
                vibrator.vibrate(100);
                tv.append("9");
                break;
            case R.id.bzero :
                vibrator.vibrate(100);
                tv.append("0");
                break;
            case R.id.bdash :
                vibrator.vibrate(100);
                tv.append("-");
                break;
            case R.id.bplus :
                vibrator.vibrate(100);
                tv.append("+");
                break;
            case R.id.fragDiallerIB : tv.setText("");
                break;
            case R.id.dialbutton :
                if(!(tv.getText().toString().equals(""))){
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:" + tv.getText().toString()));
                startActivity(phoneIntent);}
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.bone :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("1","");
                makeCall();
                break;
            case R.id.btwo :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("2","");
                makeCall();
                break;
            case R.id.bthree :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("3","");
                makeCall();
                break;
            case R.id.bfour :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("4","");
                makeCall();
                break;
            case R.id.bfive :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("5","");
                makeCall();
                break;
            case R.id.bsix :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("6","");
                makeCall();
                break;
            case R.id.bseven :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("7","");
                makeCall();
                break;
            case R.id.beight :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("8","");
                makeCall();
                break;
            case R.id.bnine :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("9","");
                makeCall();
                break;
            case R.id.bzero :
                vibrator.vibrate(100);
                string = sharedPreferences.getString("0","");
                makeCall();
                break;
        }
        return false;
    }

    private void makeCall() {
        if(!(string.equals(""))){
            tv.setText(string);
            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
            phoneIntent.setData(Uri.parse("tel:" +string ));
            startActivity(phoneIntent);}
    }
}
