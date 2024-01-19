package controller;

import domain.cards.Deck;
import domain.person.Dealer;
import domain.person.Player;
import domain.person.Players;
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
        OutputView.showWinAndLoseResult(dealer, players);
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
        OutputView.showPlayerCard(player);
    }

    private void checkDealerCard() {
        int sumOfDealerCards = dealer.getSumOfCards();
        if (sumOfDealerCards <= GET_MORE_CARD_CONDITION) {
            dealer.pickCard(deck);
            OutputView.confirmDealerRecivedCard();
            return;
        }
    }

    private List<Player> getPlayers() {
        return players.getPlayers();
    }
}
