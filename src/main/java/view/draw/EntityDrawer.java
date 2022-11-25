package view.draw;

import model.entity.Entity;
import model.entity.EntityList;
import model.tile.TileType;
import view.MainWindow;

import static model.data.CONST.TILE_SIZE;

public class EntityDrawer {


    public static void draw(MainWindow win, EntityList entityList) {
        win.pushStyle();

        win.noStroke();
        for (int i = 0; i < entityList.getSize(); i++) {
            Entity e = entityList.get(i);
            win.fill(0);
            win.ellipse(win.gap.x+ e.getPos().x+e.getSize()/2,
                        win.gap.y+ e.getPos().y+e.getSize()/2,
                    e.getSize(),
                    e.getSize());
        }
        win.popStyle();
    }
}
