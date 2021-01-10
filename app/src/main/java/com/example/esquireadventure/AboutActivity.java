package com.example.esquireadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AboutActivity extends AppCompatActivity {

    private void changeTextSize(float f, TextView t){
        t.setTextSize(f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView text = findViewById(R.id.aboutText);

        if (PreferenceManager.getDefaultSharedPreferences(this).getString("pref_text_size", "Medium").equals("Large")) {
            changeTextSize(26, text);

        } else if(PreferenceManager.getDefaultSharedPreferences(this).getString("pref_text_size", "Medium").equals("Small")){
            changeTextSize(15, text);
        }
        else {
            changeTextSize(19, text);
        }


        FloatingActionButton fab = findViewById(R.id.fabAbout);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}