package view.draw;

import model.tile.TileList;
import model.tile.TileType;
import view.MainWindow;

import static model.data.CONST.*;

public class TileDrawer {
    public static void draw(MainWindow win, TileList tileList){
        win.pushStyle();

        win.noStroke();
        for (int x = 0; x < tileList.getX(); x++) {
            for (int y = 0; y < tileList.getY(); y++) {
                TileType t = tileList.getAt(x,y).getType();
                win.fill(t.color.getRed(),t.color.getGreen(),t.color.getBlue());
                win.rect(win.gap.x+TILE_SIZE *x,
                        win.gap.y+TILE_SIZE *y,
                        TILE_SIZE,
                        TILE_SIZE);
            }
        }
        win.popStyle();
    }
}
