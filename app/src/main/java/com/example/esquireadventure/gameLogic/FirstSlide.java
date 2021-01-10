package com.example.esquireadventure.gameLogic;

import java.io.Serializable;
import static com.example.esquireadventure.R.string.*;
import static com.example.esquireadventure.R.array.*;

import static com.example.esquireadventure.gameLogic.Story.inventary;


public class FirstSlide extends Slide implements Serializable {

    public FirstSlide() {
        super(Text1, Text1_Buttons);
    }

    @Override
    public Slide[] SetNextPositionOnVisit() {
        // set nextSlides
        if(inventary.itemFromSlide2){
            nextSlides[0] = new ThirdSlide();
        }
        else {
            nextSlides[0] = new SecondSlide();
        }

        return nextSlides;

    }
}
