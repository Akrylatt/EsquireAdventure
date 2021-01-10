package com.example.esquireadventure;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SettingsFragment extends PreferenceFragment {

    public static final String PREF_DARK_MODE = "pref_dark_mode";
    public static final String PREF_LANGUAGE = "pref_lang";
    public static final String PREF_TEXT_SIZE = "pref_text_size";
    public static final String PREF_MUSIC = "pref_music";

    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);


        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                if (key.equals(PREF_DARK_MODE)) {
                    //sharedPreferences.getString(key, "").equals("true")
                    if (sharedPreferences.getBoolean(key, true)) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                } else if (key.equals(PREF_MUSIC)) {
                    if (sharedPreferences.getBoolean(key, true)) {
                        //turn on music
                    } else {
                        //turn off music
                    }

                } else if (key.equals(PREF_TEXT_SIZE)) {
                    if (sharedPreferences.getString(key, "").equals("Small")) {
                        //make the text small

                    } else {

                    }
                }


            }


        };
    }


    @Override
    public void onResume() {
        super.onResume();

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    @Override
    public void onPause() {
        super.onPause();

        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
    }




}