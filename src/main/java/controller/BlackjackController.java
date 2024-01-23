package controller;

import domain.cards.Deck;
import domain.person.Dealer;
import domain.person.Player;
import domain.person.Players;
import domain.person.wrapper.ParticipantName;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BlackjackController {

    private static final String DEALER_NAME = "딜러";
    private static final int GET_MORE_CARD_CONDITION = 16;
    private final Players players;
    private final Dealer dealer;
    private final Deck deck;

    public BlackjackController(List<String> playerNames) {
        deck = new Deck();
        players = Players.create(playerNames);
        dealer = Dealer.create(ParticipantName.create(DEALER_NAME));
    }

    public void start() {
        askPlayersBetAmount();
        divideFirstCards();
        distributeCardsToPlayers();
        checkDealerCard();
        OutputView.showTotalScore(dealer.getDealerInfo(), players.getPlayersInfo());
        dealer.fightEveryPlayer(players);
        showWinAndLoseResult();
    }

    private void askPlayersBetAmount() {
        for (Player player : getPlayers()) {
            Integer bettingMoney = InputView.askPlayerBetAmount(player.getName());
        }
    }

    private void divideFirstCards() {
        dealer.setFirstCards(deck);
        getPlayers().forEach(player -> player.setFirstCards(deck));
    }

    private void distributeCardsToPlayers() {
        OutputView.showDividePlayerCards(dealer.getDealerInfo(), players.getPlayersInfo());
        getPlayers().forEach(this::distributeCardsToPlayer);
    }

    private void distributeCardsToPlayer(Player player) {
        while (InputView.getCardCondition(player.getPlayerInfo().getPlayerName())) {
            player.pickCard(deck);
            OutputView.showPlayerCard(player.getPlayerInfo());
        }
        OutputView.showPlayerCard(player.getPlayerInfo());
    }

    private void checkDealerCard() {
        int sumOfDealerCards = dealer.getSumOfCards();
        if (sumOfDealerCards <= GET_MORE_CARD_CONDITION) {
            dealer.pickCard(deck);
            OutputView.confirmDealerRecivedCard();
        }
    }

    private List<Player> getPlayers() {
        return players.getPlayers();
    }

    private void showWinAndLoseResult() {
        OutputView.showDealerWinAndLoseResult(dealer.getWinCount(), dealer.getLoseCount(), dealer.getDrawCount());
        for (Player player : players.getPlayers()) {
            OutputView.showPlayerWinAndLoseResult(player.getName(), player.getBattleResult());
        }
    }
}
