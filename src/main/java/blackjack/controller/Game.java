package blackjack.controller;

import blackjack.domain.*;
import blackjack.domain.card.Deck;
import blackjack.domain.person.Dealer;
import blackjack.domain.person.Player;
import blackjack.domain.person.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Deck deck = new Deck();
    private final Dealer dealer = new Dealer();
    private final Result result = new Result();
    private Players players;

    public void startGame() {
        players = new Players(inputView.getPlayerNames());
        players.getPlayers().forEach(this::bet);
        initDeal();
        repeatHit();
        printResult();
    }

    public void bet(Player player) {
        int betAmount = inputView.getBetAmount(player.getName());
        result.addBetAmount(player.getName(), betAmount);
    }

    public void initDeal() {
        deck.initDeck();
        dealer.initDeal(deck);
        players.initDeal(deck);
        outputView.initDeal(players.getPlayers());
        outputView.printAllHands(dealer, players.getPlayers());
    }

    public void repeatHit() {
        players.getPlayers().forEach(this::repeatPlayerHit);
        outputView.printNewLine();
        repeatDealerHit();
    }

    public void repeatPlayerHit(Player player) {
        boolean hitDecision = true;
        while (player.isHitPossible() && hitDecision){
            hitDecision = playerHit(player);
        }
    }

    public boolean playerHit(Player player) {
        boolean hitDecision = inputView.getHitDecision(player.getName());
        if(hitDecision) {
            player.drawCard(deck);
        }
        outputView.printPlayerHand(player);
        return hitDecision;
    }

    public void repeatDealerHit() {
        while (dealer.isHitPossible()) {
            dealer.drawCard(deck);
            outputView.dealerHitComment();
        }
    }

    public void printResult() {
        outputView.printScoreResult(dealer, players.getPlayers());
        Result gameResult = players.updateResult(dealer, result);
        outputView.printGameResult(gameResult);
    }
}
