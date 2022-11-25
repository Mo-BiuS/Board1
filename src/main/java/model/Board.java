package model;

import control.Game;
import control.event.KeyEvent;
import control.input.InKey;
import control.input.InMouse;
import lombok.Getter;
import lombok.Setter;
import model.data.GameModeType;
import model.entity.Entity;
import model.entity.EntityList;
import model.entity.Player;
import model.tile.TileList;

import static model.data.CONST.*;
import static model.data.GameModeType.*;

import java.awt.*;

@Getter
public class Board {
    boolean init = false;

    TileList tileList;
    EntityList entityList;
    Camera camera;
    Player player;

    InMouse inMouse;
    InKey inKey;

    KeyEvent keyEvent;

    GameModeType gameMode;

    Game game;

    public Board(Game game){
        this.game = game;
        this.gameMode = STARTING_GAMEMODE;
        this.tileList = new TileList(this, new Point(BOARD_X, BOARD_Y));
        this.entityList = new EntityList(this);
        this.camera = new Camera(this);
        this.inKey = new InKey(this);
        this.inMouse = new InMouse(this);
        this.player = new Player(new Point(STARTING_POS_X,STARTING_POS_Y));
        this.keyEvent = new KeyEvent(this);
        entityList.add(player);
        init = true;
    }

    public void run() {
        keyEvent.directionEvent();
        keyEvent.gameModeChange();

        tileList.run();
        entityList.run();
    }

    public void setNextGameMode() {
        if(gameMode == EXPLORING){
            player.stopMoving();
            gameMode = BUILDING;
        }
        else gameMode = EXPLORING;
    }
}
