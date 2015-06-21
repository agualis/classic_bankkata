package com.senpai.bowling;

public class Game {

    public static final int ALL_PINS = 10;
    private static final int MAX_TRIES = 2;

    int tries = 0;
    private int score = 0;
    private Frame currentFrame;
    private Frame firstFrame;
    private Frame secondFrame;

    public Game() {
        firstFrame = new Frame();
        secondFrame = new Frame();
        currentFrame = firstFrame;
        tries = 0;
    }

    public int score() {
        return firstFrame.score() + secondFrame.score() + bonuses();
    }

    private int bonuses() {
        if (firstFrame.score() == ALL_PINS) {
            return secondFrame.score();
        } else {
            return 0;
        }
    }

    public void roll(int pinsDown) {
        incrementTries();
        anotate(pinsDown);
        updateCurrentFrameIfNeeded();
    }

    private void updateCurrentFrameIfNeeded() {
        if (tries == 0) {
            currentFrame = secondFrame;
        }
    }


    private void anotate(int pinsDown) {
        currentFrame.anotate(pinsDown);
    }

    private void incrementTries() {
        if (tries == MAX_TRIES) {
            tries = 0;
        }
        tries += 1;
    }

}
