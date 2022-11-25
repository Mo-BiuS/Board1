package model.entity;

import lombok.Getter;

import java.awt.*;

import static model.data.CONST.*;

@Getter
public class Player extends Entity {
    boolean goNorth;
    boolean goSouth;
    boolean goEast;
    boolean goWest;

    public Player(Point pos){
        super(pos);
    }

    public void goEast(boolean t) {
        goEast= t;
    }
    public void goNorth(boolean t) {
        goNorth = t;
    }
    public void goSouth(boolean t) {
        goSouth = t;
    }
    public void goWest(boolean t) {
        goWest = t;
    }
    public void stopMoving(){
        goNorth = goSouth = goEast = goWest = false;
    }

    @Override
    public void run(){
        if(System.currentTimeMillis() - time > ENTITY_REFRESH_RATE){
            moving();
            time = System.currentTimeMillis();
        }

    }

    private void moving(){
        if(goNorth && pos.y > 0)pos.translate(0,-movingSpeed);
        if(goSouth && pos.y < BOARD_X*TILE_SIZE-size)pos.translate(0,movingSpeed);
        if(goEast && pos.x < BOARD_Y*TILE_SIZE-size)pos.translate(movingSpeed,0);
        if(goWest && pos.x > 0)pos.translate(-movingSpeed,0);
    }
}
