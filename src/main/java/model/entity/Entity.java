package model.entity;

import lombok.Getter;
import model.data.CONST;

import java.awt.*;

import static model.data.CONST.*;


@Getter
public class Entity {
    Point pos;
    Point des;
    int movingSpeed;
    int size;
    long time;

    public Entity(Point pos){
        this.pos = pos;
        movingSpeed = ENTITY_BASE_SPEED;
        size = CONST.TILE_SIZE*2;
        time = System.currentTimeMillis();
    }

    public void run() {
        if(System.currentTimeMillis() - time > ENTITY_REFRESH_RATE){
            time = System.currentTimeMillis();
        }
    }
}