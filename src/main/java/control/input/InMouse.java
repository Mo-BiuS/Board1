package control.input;

import lombok.Getter;
import model.Board;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InMouse {
    Board board;
    List<Integer> inMouse;

    public InMouse(Board board){
        this.board = board;
        inMouse = new ArrayList<>();
    }

    public void mousePressed(Integer mouse){
        inMouse.add(mouse);
    }
    public void mouseReleased(Integer mouse){
        inMouse.remove(mouse);
    }
}
