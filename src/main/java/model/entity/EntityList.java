package model.entity;

import lombok.Getter;
import model.Board;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EntityList {
    List<Entity> entityList;

    Board board;

    public EntityList(Board board){
        this.board = board;
        entityList = new ArrayList<>();
    }

    public void run() {
        for(int i = 0; i < entityList.size(); i++){
            entityList.get(i).run();
        }
    }

    public int getSize(){
        return entityList.size();
    }
    public Entity get(int i){
        return entityList.get(i);
    }

    public boolean add(Entity entity) {
        return entityList.add(entity);
    }
}
