package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    public int score;
    public int maxTile;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if(!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }

        for (int j = 0; j < FIELD_WIDTH; j++) {
            for (int i = 0; i < FIELD_WIDTH - 1; i++) {
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
            }
        }

        return false;
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

    private boolean compressTiles(Tile[] tiles) {
        boolean res = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if(tiles[i].value == 0 && tiles[i+1].value != 0)
            {
                int temp = tiles[i].value;
                tiles[i].value = tiles[i+1].value;
                tiles[i+1].value = temp;
                i = -1;
                res = true;
            }
        }
        return res;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean res = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if(tiles[i].value == 0) break;
            if(tiles[i].value == tiles[i+1].value) {
                tiles[i].value *= 2;
                tiles[i+1].value = 0;
                score += tiles[i].value;
                if(tiles[i].value > maxTile) maxTile = tiles[i].value;
                compressTiles(tiles);
                i = 0;
                res = true;
            }
        }
        return  res;
    }

    public void left() {
        boolean ifEdit = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if(compressTiles(gameTiles[i]) || mergeTiles(gameTiles[i])) {
                ifEdit = true;
            }
        }
        if(ifEdit) addTile();
    }

    private void rotate (int count) {
        for (int i = 0; i < count; i++) {
            for (int k = 0; k < FIELD_WIDTH/2; k++) {
                for (int j = k; j < FIELD_WIDTH - 1 - k; j++) {
                    Tile tmp = gameTiles[k][j];
                    gameTiles[k][j]  = gameTiles[j][FIELD_WIDTH-1-k];
                    gameTiles[j][FIELD_WIDTH-1-k] = gameTiles[FIELD_WIDTH-1-k][FIELD_WIDTH-1-j];
                    gameTiles[FIELD_WIDTH-1-k][FIELD_WIDTH-1-j] = gameTiles[FIELD_WIDTH-1-j][k];
                    gameTiles[FIELD_WIDTH-1-j][k] = tmp;
                }
            }
        }
    }

    public void up() {
        rotate(1);
        left();
        rotate(3);
    }

    public void right() {
        rotate(2);
        left();
        rotate(2);
    }

    public void down() {
        rotate(3);
        left();
        rotate(1);
    }
}
