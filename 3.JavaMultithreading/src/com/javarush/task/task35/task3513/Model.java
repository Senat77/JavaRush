package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    public int score;
    public int maxTile;

    public Model() {
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            list.addAll(Arrays.asList(gameTiles[i]));
        }
        list.removeIf(tile -> (tile.value != 0));
        return list;
    }

    private void addTile () {
        List<Tile> emptyTilesList = getEmptyTiles();
        if(!emptyTilesList.isEmpty())
            emptyTilesList.get((int) (Math.random() * emptyTilesList.size())).setValue(Math.random() < 0.9 ? 2 : 4);
    }

    protected void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        for (int i = 0; i < 2; i++) {
            addTile();
        }
        score = 0;
        maxTile = 0;
    }

    private void compressTiles(Tile[] tiles) {
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if(tiles[i].value == 0 && tiles[i+1].value != 0)
            {
                int temp = tiles[i].value;
                tiles[i].value = tiles[i+1].value;
                tiles[i+1].value = temp;
                i = -1;
            }
        }
    }

    private void mergeTiles(Tile[] tiles) {
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if(tiles[i].value == 0) break;
            if(tiles[i].value == tiles[i+1].value) {
                tiles[i].value *= 2;
                tiles[i+1].value = 0;
                score += tiles[i].value;
                if(tiles[i].value > maxTile) maxTile = tiles[i].value;
                compressTiles(tiles);
                i = 0;
            }
        }
    }
}
