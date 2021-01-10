package com.example.esquireadventure.gameLogic;

import com.example.esquireadventure.GameActivity;
import com.example.esquireadventure.R;

import java.io.Serializable;

public class Story implements Serializable {


    public Slide[] nextSlides = new Slide[6];
    public Slide currentSlide;

    public static Inventary inventary = new Inventary();

    public Story(){
        currentSlide = new FirstSlide();
    }
/*
    public void setMainText(){
        //c.getString(R.string.address);
       // String s = ga.getString(R.string.Text1);
       // ga.text.setText(s);
    }
*/

}
