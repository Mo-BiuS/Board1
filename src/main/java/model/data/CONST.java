package model.data;

public class CONST {
    public static final int WINDOW_SIZE_X = 1200;
    public static final int WINDOW_SIZE_Y = 900;
    public static final int TILE_SIZE = 32;

    public static final int BOARD_X = 32;
    public static final int BOARD_Y = 32;

    public static final int SCREEN_SPEED_BORDER = 4;
    public static final int SCREEN_SPEED_WHEEL = 12;

    public static final int STARTING_POS_X = BOARD_X/2*TILE_SIZE;
    public static final int STARTING_POS_Y = BOARD_Y/2*TILE_SIZE;

    public static final long ENTITY_REFRESH_RATE = 10;
    public static final int ENTITY_BASE_SPEED = 2;

    public static final GameModeType STARTING_GAMEMODE = GameModeType.EXPLORING;

    public static final char NORTH = 'z';
    public static final char EAST = 'd';
    public static final char SOUTH = 's';
    public static final char WEST = 'q';

}
