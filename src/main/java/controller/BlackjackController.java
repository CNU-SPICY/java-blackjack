package controller;

import domain.Dealer;
import domain.Deck;
import domain.Player;
import domain.Players;
import view.InputView;
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
        divideFirstCards();
        OutputView.showDividePlayerCards(dealer, players);

        distributeCardsToPlayers();
    }

    private void divideFirstCards() {
        dealer.setFirstCards(deck);
        players.getPlayers().forEach(player -> player.setFirstCards(deck));
    }

    private void distributeCardsToPlayers() {
        players.getPlayers().forEach(this::distributeCardsToPlayer);
    }

    private void distributeCardsToPlayer(Player player) {
        while (InputView.getCardCondition(player)) {
            player.pickCard(deck);
            OutputView.showPlayerCard(player);
        }
    }
}
