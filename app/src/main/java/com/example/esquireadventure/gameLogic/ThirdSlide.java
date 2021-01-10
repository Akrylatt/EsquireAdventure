package com.example.esquireadventure.gameLogic;
import java.io.Serializable;

import static com.example.esquireadventure.gameLogic.Story.inventary;

import static com.example.esquireadventure.R.string.*;
import static com.example.esquireadventure.R.array.*;

public class ThirdSlide extends Slide implements Serializable {

    public ThirdSlide() {
        super(Text3, Text3_Buttons);
        inventary.itemFromSlide2 = false;
    }

    @Override
    public Slide[] SetNextPositionOnVisit() {
        nextSlides[0] = new FirstSlide();
        return nextSlides;
    }
}
