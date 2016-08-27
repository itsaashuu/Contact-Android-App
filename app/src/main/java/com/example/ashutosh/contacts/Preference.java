package com.example.ashutosh.contacts;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by ashutosh on 18/7/16.
 */
public class Preference extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new UserSettings()).commit();
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return UserSettings.class.getName().equals(fragmentName);
    }
}
