package control;

import processing.core.PApplet;
import view.MainWindow;

public class App extends PApplet {
    public static final Game GAME = new Game();

    public static void main(String[] args) {
        GAME.start();
        PApplet.main(MainWindow.class);
    }
}