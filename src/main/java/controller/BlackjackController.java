package controller;

import domain.cards.Deck;
import domain.person.Dealer;
import domain.person.Money;
import domain.person.Player;
import domain.person.Players;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        dealer = Dealer.create(DEALER_NAME);
    }

    public void start() {
        var initPlayersBettingInfo = initPlayersBettingInfo();
        divideFirstCards();
        bettleBeforeDistribution();
        distributeCardsToPlayers();
        checkDealerCard();
        OutputView.showTotalScore(dealer.getDealerDto(), players.getPlayersDto());
        dealer.fightEveryPlayer(players, initPlayersBettingInfo);
        showFinalProfit(players, dealer);
    }

    private void bettleBeforeDistribution() {
        dealer.fightBeforeDistribution(players);
    }

    private Map<Player, Money> initPlayersBettingInfo() {
        Map<Player, Money> initBettingInfo = new HashMap<>();
        for (Player player : getPlayers()) {
            Money bettingMoney = Money.create(InputView.askPlayerBetAmount(player.getName()));
            player.betting(bettingMoney);
            initBettingInfo.put(player, bettingMoney);
        }
        return initBettingInfo;
    }

    private void divideFirstCards() {
        dealer.setFirstCards(deck);
        getPlayers().forEach(player -> player.setFirstCards(deck));
    }

    private void distributeCardsToPlayers() {
        OutputView.showDividePlayerCards(dealer.getDealerDto(), players.getPlayersDto());
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

    private void showFinalProfit(Players players, Dealer dealer) {
        OutputView.showTotalMoney(players.getPlayersDto(), dealer.getDealerDto());
    }
}
