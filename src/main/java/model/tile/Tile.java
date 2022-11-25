package model.tile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tile {
    TileType type;

    Tile(TileType type){
        this.type = type;
    }

    public void run() {

    }
}