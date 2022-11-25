package control;

import lombok.Getter;
import model.Board;
import model.Camera;

@Getter
public class Game extends Thread{
    Board activeBoard;

    @Override
    public void run(){
        activeBoard = new Board(this);
        while(!this.isInterrupted()) {
            activeBoard.run();
        }
    }
}
