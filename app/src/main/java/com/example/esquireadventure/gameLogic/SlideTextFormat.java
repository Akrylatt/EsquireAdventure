package com.example.esquireadventure.gameLogic;

import java.io.Serializable;

public class SlideTextFormat implements Serializable {
    int mainText;
    int buttonsText;

    public SlideTextFormat(int mainText, int buttons){
        this.mainText = mainText;
        this.buttonsText = buttons;
    }

    public int getMainText() {
        return mainText;
    }

    public int getButtons() {
        return buttonsText;
    }
}
