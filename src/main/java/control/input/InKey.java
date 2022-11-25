package control.input;

import lombok.Getter;
import model.Board;

import java.util.*;

public class InKey {
    Board board;
    HashSet<Character> inKey;

    public InKey(Board board){
        this.board = board;
        inKey = new HashSet<>();
    }

    public synchronized void keyPressed(Character key){
        inKey.add(key);
    }
    public synchronized void keyReleased(Character key){
        inKey.remove(key);
    }
    public synchronized boolean contains(Character c){
        return inKey.contains(c);
    }

    @Override
    public String toString(){
        return inKey.toString();
    }
}
