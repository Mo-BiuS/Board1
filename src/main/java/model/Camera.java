package model;

import model.entity.Player;

import java.awt.*;
import java.awt.geom.Point2D;

import static model.data.CONST.*;
import static model.data.GameModeType.*;

public class Camera {
    Board board;
    public Point centerAt;
    public Point centerTo;

    public Camera(Board board) {
        this.board = board;
        centerAt = new Point(BOARD_X / 2 * TILE_SIZE, BOARD_Y / 2 * TILE_SIZE);
        centerTo = new Point(BOARD_X / 2 * TILE_SIZE, BOARD_Y / 2 * TILE_SIZE);
    }

    public void run(int mouseX, int mouseY) {
        if (board.getGameMode() == BUILDING) {
            buildingModeBorderCamera(mouseX, mouseY);
        } else if (board.getGameMode() == EXPLORING) {
            Point pos = board.getPlayer().getPos();
            centerAt.move((pos.x) * 2, (pos.y) * 2);
            centerTo.move((pos.x) * 2, (pos.y) * 2);
        }
    }

    private void buildingModeBorderCamera(int mouseX, int mouseY) {

        if (mouseX < TILE_SIZE)goWest();
        else if (mouseX > WINDOW_SIZE_X - TILE_SIZE)goEast();
        //=============================================================================================
        if (centerTo.x < centerAt.x) {
            if (centerTo.x >= centerAt.x - SCREEN_SPEED_BORDER) centerAt = new Point(centerTo.x, centerAt.y);
            else centerAt.move(centerAt.x - SCREEN_SPEED_BORDER, centerAt.y);
        } else if (centerTo.x > centerAt.x) {
            if (centerTo.x <= centerAt.x + SCREEN_SPEED_BORDER) centerAt = new Point(centerTo.x, centerAt.y);
            else centerAt.move(centerAt.x + SCREEN_SPEED_BORDER, centerAt.y);
        }
        //=============================================================================================
        if (mouseY < TILE_SIZE)goNorth();
        else if (mouseY > WINDOW_SIZE_Y - TILE_SIZE)goSouth();
        //=============================================================================================
        if (centerTo.y < centerAt.y) {
            if (centerTo.y >= centerAt.y - SCREEN_SPEED_BORDER) centerAt.move(centerAt.x, centerTo.y);
            else centerAt.move(centerAt.x, centerAt.y - SCREEN_SPEED_BORDER);
        } else if (centerTo.y > centerAt.y) {
            if (centerTo.y <= centerAt.y + SCREEN_SPEED_BORDER) centerAt.move(centerAt.x, centerTo.y);
            else centerAt.move(centerAt.x, centerAt.y + SCREEN_SPEED_BORDER);
        }
    }

    public void goNorth() {
        if(centerTo.y > 0)
            centerTo.move(centerTo.x,(centerAt.y / TILE_SIZE) * TILE_SIZE - TILE_SIZE);
    }

    public void goEast() {
        if(centerTo.x < BOARD_X * TILE_SIZE * 2)
            centerTo.move( (centerAt.x / TILE_SIZE) * TILE_SIZE + TILE_SIZE, centerTo.y);
    }

    public void goSouth() {
        if(centerTo.y < BOARD_Y * TILE_SIZE * 2)
            centerTo.move(centerTo.x,(centerAt.y / TILE_SIZE) * TILE_SIZE + TILE_SIZE);
    }

    public void goWest() {
        if(centerTo.x > 0)
            centerTo.move((centerAt.x / TILE_SIZE) * TILE_SIZE - TILE_SIZE, centerTo.y);
    }
}