package controller;

import domain.cards.Deck;
import domain.person.Dealer;
import domain.person.Money;
import domain.person.Player;
import domain.person.Players;
import java.util.HashMap;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class BlackjackController {

    public void start() {
        final var playerNames = InputView.inputPlayerNames();
        Deck deck = new Deck();
        Players players = Players.create(playerNames);
        Dealer dealer = Dealer.create();
        var initPlayersBettingInfo = initPlayersBettingInfo(players);
        divideFirstCards(deck, dealer, players);
        bettleBeforeDistribution(dealer, players);
        distributeCardsToPlayers(deck, dealer, players);
        checkDealerCard(deck, dealer);
        OutputView.showTotalScore(dealer.getDealerDto(), players.getPlayersDto());
        dealer.fightEveryPlayer(players, initPlayersBettingInfo);
        showFinalProfit(players, dealer);
    }

    private Map<Player, Money> initPlayersBettingInfo(Players players) {
        Map<Player, Money> initBettingInfo = new HashMap<>();
        for (Player player : players.getPlayers()) {
            Money bettingMoney = Money.create(InputView.askPlayerBetAmount(player.getName()));
            player.betting(bettingMoney);
            initBettingInfo.put(player, bettingMoney);
        }
        return initBettingInfo;
    }

    private void divideFirstCards(Deck deck, Dealer dealer, Players players) {
        dealer.setFirstCards(deck);
        players.getPlayers().forEach(player -> player.setFirstCards(deck));
    }

    private void bettleBeforeDistribution(Dealer dealer, Players players) {
        dealer.fightBeforeDistribution(players);
    }

    private void distributeCardsToPlayers(Deck deck, Dealer dealer, Players players) {
        OutputView.showDividePlayerCards(dealer.getDealerDto(), players.getPlayersDto());
        players.getPlayers().forEach(player -> distributeCardsToPlayer(deck, player));
    }

    private void distributeCardsToPlayer(Deck deck, Player player) {
        while (InputView.getCardCondition(player.getPlayerInfo().getPlayerName())) {
            player.pickCard(deck);
            OutputView.showPlayerCard(player.getPlayerInfo());
        }
        OutputView.showPlayerCard(player.getPlayerInfo());
    }

    private void checkDealerCard(Deck deck, Dealer dealer) {
        if (dealer.canPickCard()) {
            dealer.pickCard(deck);
            OutputView.confirmDealerRecivedCard();
        }
    }

    private void showFinalProfit(Players players, Dealer dealer) {
        OutputView.showTotalMoney(players.getPlayersDto(), dealer.getDealerDto());
    }
}
