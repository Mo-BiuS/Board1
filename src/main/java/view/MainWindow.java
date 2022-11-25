package view;

import control.App;
import model.Board;
import model.data.GameModeType;
import processing.core.PApplet;
import view.draw.EntityDrawer;
import view.draw.MouseDrawer;
import view.draw.TileDrawer;

import java.awt.*;

import static model.data.CONST.*;
import static model.data.GameModeType.*;

public class MainWindow extends PApplet {
    public Board board = App.GAME.getActiveBoard();
    public Point gap;
    public Point mousePos;

    @Override
    public void settings() {
        size(WINDOW_SIZE_X, WINDOW_SIZE_Y);

        gap = new Point((WINDOW_SIZE_X-board.getCamera().centerAt.x)/2, (WINDOW_SIZE_Y-board.getCamera().centerAt.y)/2);
        mousePos = new Point();
    }

    @Override
    public void setup() {
        background(0);
    }

    @Override
    public void draw() {
        background(0);
        board.getCamera().run(mouseX,mouseY);
        gap.move((WINDOW_SIZE_X-board.getCamera().centerAt.x)/2, (WINDOW_SIZE_Y-board.getCamera().centerAt.y)/2);
        mousePos = new Point((mouseX-gap.x)/TILE_SIZE,(mouseY-gap.y)/TILE_SIZE);

        TileDrawer.draw(this, board.getTileList());
        EntityDrawer.draw(this, board.getEntityList());

        if(board.getGameMode() == BUILDING)
            MouseDrawer.draw(this, mousePos);
    }

    @Override
    public void keyPressed(){
        board.getInKey().keyPressed(key);
    }
    @Override
    public void keyReleased(){
        board.getInKey().keyReleased(key);

    }
    @Override
    public void mousePressed(){
        board.getInMouse().mousePressed(mouseButton);
    }
    @Override
    public void mouseReleased(){
        board.getInMouse().mouseReleased(mouseButton);

    }
}
