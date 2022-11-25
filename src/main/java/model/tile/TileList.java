package model.tile;

import model.Board;

import java.awt.*;

public class TileList {
    Tile[][] tileList;
    Point size;

    Board board;

    public TileList(Board board, Point size){
        this.board = board;
        this.size = size;
        tileList = new Tile[size.x][size.y];

        //Fill
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                tileList[x][y] = new Tile(TileType.GROUND);
            }
        }
    }

    public void run() {
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                tileList[x][y].run();
            }
        }
    }

    public int getX() {
        return size.x;
    }

    public int getY() {
        return size.y;
    }

    public Tile getAt(int x, int y) {
        if(isIn(x,y))return tileList[x][y];
        else return null;
    }

    private boolean isIn(int x, int y) {
        return(x >= 0 && y >= 0 && x < size.x && y < size.y);
    }
}
