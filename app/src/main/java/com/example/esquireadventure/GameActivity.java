package com.example.esquireadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.esquireadventure.gameLogic.Slide;
import com.example.esquireadventure.gameLogic.SlideTextFormat;
import com.example.esquireadventure.gameLogic.Story;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static com.example.esquireadventure.R.string.*;
import static com.example.esquireadventure.R.array.*;



public class GameActivity extends AppCompatActivity {

    public TextView text;
   // public Button b1, b2, b3, b4, b5, b6;
    public Button[] buttons = new Button[6];
   // Story story = new Story(this);
    Story story;


    //
    public  final static String SER_KEY = "savedStory";
    File outputFile;

    FileOutputStream fos = null;
    ObjectOutputStream out = null;
    FileInputStream fis = null;
    ObjectInputStream in = null;
    //

    private void changeTextSize(float f, TextView t, Button[] bs){
        t.setTextSize(f);

        for (Button b:bs) {
            b.setTextSize(f);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //
        outputFile = new File(getApplicationContext().getFilesDir(), SER_KEY);
        // read the object from file

        if (!outputFile.exists()) {
            story = new Story();
            Log.d("storySer", "New Story created");
        }
        else {
            loadGame();
            Log.d("storySer", "Story load from onCreate");
        }



        //
        FloatingActionButton fab = findViewById(R.id.fab);

        text = findViewById(R.id.storyText);

        buttons[0] = findViewById(R.id.button);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);

        for (Button b:buttons
             ) {
            b.setTransformationMethod(null);
        }

/*
        b1.setTransformationMethod(null);
        b2.setTransformationMethod(null);
        b3.setTransformationMethod(null);
        b4.setTransformationMethod(null);
        b5.setTransformationMethod(null);
        b6.setTransformationMethod(null);

 */

        if (PreferenceManager.getDefaultSharedPreferences(this).getString("pref_text_size", "Medium").equals("Large")) {
            changeTextSize(26, text, buttons);

        } else if(PreferenceManager.getDefaultSharedPreferences(this).getString("pref_text_size", "Medium").equals("Small")){
            changeTextSize(14, text, buttons);
        }
        else {
            changeTextSize(17, text, buttons);
        }

        story.nextSlides = story.currentSlide.SetNextPositionOnVisit();
        setSlideText(story.currentSlide.getSlideTextFormat());

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void button1OnClick(View view) throws IOException {
       onVisit(0);

    }
    public void button2OnClick(View view){
        onVisit(1);

    }

    public void button3OnClick(View view){
        onVisit(2);
    }

    public void button4OnClick(View view){
        onVisit(3);
    }

    public void button5OnClick(View view){
        onVisit(4);
    }

    public void button6OnClick(View view){
        onVisit(5);
    }

    private void saveGame(){

        try {
            fos = new FileOutputStream(outputFile);
            out = new ObjectOutputStream(fos);
            out.writeObject(story);

            out.close();
            Log.d("storySer", "story save" + story.toString());
        } catch (Exception ex) {
            Log.d("storySer", ex.toString());
            ex.printStackTrace();

        }

    }

    private void loadGame(){
        try {
            fis = new FileInputStream(outputFile);
            in = new ObjectInputStream(fis);
            story = (Story) in.readObject();
            in.close();

            Log.d("storySer", "story read" + story.toString());
        } catch (Exception ex) {
            Log.d("storySer", ex.toString());
            ex.printStackTrace();
        }

    }

    /**
     * This method get IDs of text and button text array and set it for the preview
     * @param stf is a SlideTextFormat which contains two IDs - of text and buttons
     */
    private void setSlideText(SlideTextFormat stf){

        String mainText = getResources().getString(stf.getMainText());
        String[] buttonsText = getResources().getStringArray(stf.getButtons());

        text.setText(mainText);

        int i = 0;
        for (Button b: buttons
             ) {
            if(buttonsText[i].equals("")){
                b.setVisibility(View.INVISIBLE);
            }
            else{
                b.setVisibility(View.VISIBLE);
                b.setText(buttonsText[i]);
            }
            i++;
        }
    }

    private void onVisit(int buttonNumber){
        Slide mySlide = story.nextSlides[buttonNumber];
        story.nextSlides = mySlide.SetNextPositionOnVisit();
        setSlideText(mySlide.getSlideTextFormat());
        story.currentSlide = mySlide;
        saveGame();


    }
}