package src.main.java;

import src.main.java.controller.GameController;
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}
