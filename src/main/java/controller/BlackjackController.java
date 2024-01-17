package controller;

import domain.Dealer;
import domain.Players;

public class BlackjackController {

    private final Players players;
    private final Dealer dealer;

    public BlackjackController(String[] playerNames) {
        players = new Players(playerNames);
        dealer = new Dealer();
    }

    public void start() {

    }
}
