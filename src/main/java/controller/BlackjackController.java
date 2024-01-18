package controller;

import domain.Dealer;
import domain.Deck;
import domain.Players;
import view.OutputView;

public class BlackjackController {

    private static final String DEALER_NAME = "딜러";
    private final Players players;
    private final Dealer dealer;
    private final Deck deck;

    public BlackjackController(String[] playerNames) {
        deck = new Deck();
        players = new Players(playerNames);
        dealer = new Dealer(DEALER_NAME);
    }

    public void start() {
        firstDivideCards();
        OutputView.showDividePlayerCards(dealer, players);
    }

    private void firstDivideCards() {
        dealer.firstCardSetting(deck);
        players.getPlayers().forEach(player -> player.firstCardSetting(deck));
    }

}
