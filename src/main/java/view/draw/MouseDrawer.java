package view.draw;

import view.MainWindow;

import static model.data.CONST.*;

import java.awt.*;

public class MouseDrawer {
    public static void draw(MainWindow win, Point mousePos){
        win.pushStyle();

        win.strokeWeight(2);
        win.noFill();
        win.rect(mousePos.x*TILE_SIZE+win.gap.x,
                mousePos.y*TILE_SIZE+win.gap.y,
                TILE_SIZE,
                TILE_SIZE);

        win.popStyle();
    }
}
