package blackjack;

import blackjack.controller.Game;

public class BlackjackApplication {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}