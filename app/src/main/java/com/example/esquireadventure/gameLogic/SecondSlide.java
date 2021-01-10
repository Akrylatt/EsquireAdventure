package com.example.esquireadventure.gameLogic;

import java.io.Serializable;
import java.util.Random;

import static com.example.esquireadventure.R.string.*;
import static com.example.esquireadventure.R.array.*;
import static com.example.esquireadventure.gameLogic.Story.inventary;


public class SecondSlide extends Slide implements Serializable {
    public SecondSlide() {
        super(Text2, Text2_Buttons);
        inventary.itemFromSlide2 = true;
    }

    @Override
    public Slide[] SetNextPositionOnVisit() {
        Random ran = new Random();
        nextSlides[0] = new FirstSlide();
        int i = ran.nextInt(2);
        if(i == 0){
            nextSlides[1] = new FirstSlide();
        }
        else{
            nextSlides[1] = new SecondSlide();
        }
        return nextSlides;
    }

}
