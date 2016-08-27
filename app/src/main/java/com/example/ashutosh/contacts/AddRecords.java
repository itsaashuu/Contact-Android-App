package com.example.ashutosh.contacts;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddRecords extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    ArrayList<Fragment> frag;
    MyAdapter myAdapter;
    PagerTitleStrip pagerTitleStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);
        toolbar = (Toolbar) findViewById(R.id.tool_bar_2);
        setSupportActionBar(toolbar);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.pagerAdd);
        pagerTitleStrip = (PagerTitleStrip)findViewById(R.id.addTitle);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
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
        toolbar.setBackgroundColor(color);
        pagerTitleStrip.setBackgroundColor(color);

        viewPager.setAdapter(myAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.discard :
                break;
            case R.id.save:
                dbAdapter db = new dbAdapter(getBaseContext());
                frag = myAdapter.getAllFragments();
                Personal_Details p1 = null;
                Proffesional_Details p2 = null;
                Social s = null;
                try{
                    p1 = (Personal_Details) frag.get(0);
                    p2 = (Proffesional_Details) frag.get(1);
                    s = (Social) frag.get(2);
                    Person p = new Person(p1.getName(),p1.getLastName(),p1.getPhone(),p1.getEmail(),p1.getDOB(),p1.getImage(),
                            p2.getCName(),p2.getTitle(),p2.getIM(),p2.getwebsite(),p2.getOfficeA(),
                            s.getNickName(),s.getIntro(),s.getFb(),s.getTwitter(),s.getInsta());
                    long id = db.addPerson(p);
                    if(id>0){
                        Toast.makeText(this,"Successsful",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,"UNSuccesssful",Toast.LENGTH_LONG).show();
                    }
                }catch (ArrayIndexOutOfBoundsException a){
                    a.printStackTrace();
                }

                break;
            default: break;
        }
        return true;
    }

}

class MyAdapter extends FragmentStatePagerAdapter{

    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();


    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Personal_Details();
                break;
            case 1:
                fragment = new Proffesional_Details();
                break;
            case 2 :
                fragment = new Social();
                break;
            default:break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Personal";
            case 1 : return "Professional";
            case 2 : return "Social";
            default:return null ;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }


    public ArrayList<Fragment> getAllFragments() {
        ArrayList<Fragment> list = new ArrayList<Fragment>();

        for(int i = 0; i < registeredFragments.size(); i++) {
            int key = registeredFragments.keyAt(i);
            list.add(registeredFragments.get(key));
        }

        return list;
    }
}