package control.event;

import model.Board;

import java.util.ArrayList;
import java.util.List;
import control.input.InKey;

import static model.data.CONST.*;
import static model.data.GameModeType.*;

public class KeyEvent {
    Board board;
    boolean gameModeChanged = false;
    public KeyEvent(Board board) {
        this.board = board;
    }

    public void directionEvent(){
        InKey keyList = board.getInKey();
        if(board.getGameMode() == EXPLORING) {
            board.getPlayer().goNorth(keyList.contains(NORTH));
            board.getPlayer().goEast(keyList.contains(EAST));
            board.getPlayer().goSouth(keyList.contains(SOUTH));
            board.getPlayer().goWest(keyList.contains(WEST));
        }
        else if(board.getGameMode() == BUILDING){
            if (keyList.contains(NORTH)) {

                board.getCamera().goNorth();
            }
            if (keyList.contains(EAST)) {
                board.getCamera().goEast();
            }
            if (keyList.contains(SOUTH)) {
                board.getCamera().goSouth();
            }
            if (keyList.contains(WEST)) {
                board.getCamera().goWest();
            }
        }
    }
    public void gameModeChange(){
        InKey keyList = board.getInKey();
        if(keyList.contains((char)9) && !gameModeChanged){
            board.setNextGameMode();
        }
        gameModeChanged = keyList.contains((char)9);
    }
}
