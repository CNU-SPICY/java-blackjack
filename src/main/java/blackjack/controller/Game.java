package blackjack.controller;

import blackjack.domain.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Deck deck = new Deck();
    private final Dealer dealer = new Dealer();
    private Players players;

    public void startGame() {
        players = new Players(inputView.getPlayerNames());
        initDeal();
        repeatHit();
        printResult();
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
        outputView.printNewLine();
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
        Result gameResult = players.getResult(dealer);
        outputView.printGameResult(gameResult);
    }
}
