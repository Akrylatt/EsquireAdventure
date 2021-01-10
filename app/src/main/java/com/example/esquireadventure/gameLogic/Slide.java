package com.example.esquireadventure.gameLogic;


import java.io.Serializable;

public abstract class Slide implements Serializable {

    protected SlideTextFormat slideTextFormat;
    protected Slide[] nextSlides = {null, null, null, null, null, null};

    public Slide(int textID, int buttonID){
        slideTextFormat = new SlideTextFormat(textID, buttonID);
    }

    public abstract Slide[] SetNextPositionOnVisit(); // sets next positions in the story instance



    public SlideTextFormat getSlideTextFormat(){
        return slideTextFormat;
    }

}
