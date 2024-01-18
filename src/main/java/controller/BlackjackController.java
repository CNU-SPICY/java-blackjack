package controller;

import domain.Dealer;
import domain.Deck;
import domain.Player;
import domain.Players;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BlackjackController {

    private static final String DEALER_NAME = "딜러";
    private static final int GET_MORE_CARD_CONDITION = 16;
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
        checkDealerCard();

        OutputView.showTotalScore(dealer, players);
        dealer.fightEveryPlayer(players);
    }

    private void divideFirstCards() {
        dealer.setFirstCards(deck);
        getPlayers().forEach(player -> player.setFirstCards(deck));
    }

    private void distributeCardsToPlayers() {
        getPlayers().forEach(this::distributeCardsToPlayer);
    }

    private void distributeCardsToPlayer(Player player) {
        while (InputView.getCardCondition(player)) {
            player.pickCard(deck);
            OutputView.showPlayerCard(player);
        }
    }

    private void checkDealerCard() {
        int sumOfDealerCards = dealer.getSumOfCards();
        if (sumOfDealerCards <= GET_MORE_CARD_CONDITION) {
            dealer.pickCard(deck);
        }
        OutputView.confirmDealerRecivedCard();
    }

    private List<Player> getPlayers() {
        return players.getPlayers();
    }
}
