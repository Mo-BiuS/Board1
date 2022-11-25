package model.tile;

import java.awt.*;

public enum TileType {
    PLATFORM(Color.GRAY,    true,false,false,false),
    GROUND( Color.white,    true, true, false, false),
    ENTRY(  Color.blue,     false, true, true, false),
    EXIT(   Color.red,      false, true, false, true),
    WALL(   Color.black,    false, false, false, false);

    public final Color color;
    public final boolean buildable;
    public final boolean traversable;
    public final boolean entryPoint;
    public final boolean exitPoint;

    TileType(Color color, boolean buildable, boolean traversable, boolean entryPoint, boolean exitPoint){
        this.buildable = buildable;
        this.color = color;
        this.traversable = traversable;
        this.entryPoint = traversable && entryPoint;
        this.exitPoint = traversable && exitPoint;
    }

}
