package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private static final int WINNING_TILE = 2048;

    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public void resetGame() {
        view.isGameLost = view.isGameWon = false;
        model.resetGameTiles();
    }

    public Tile[][] getGameTiles()
    {
        return model.getGameTiles();
    }

    public int getScore()
    {
        return model.score;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
