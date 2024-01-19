package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.domain.Result;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Game {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Dealer dealer = new Dealer();
    private Players players;

    public void startGame() {
        players = new Players(inputView.getPlayerNames());
        dealer.initDeal();
        players.initDeal();
        outputView.initDeal(players.getPlayers());
        outputView.printAllHands(dealer, players.getPlayers());
        players.getPlayers().forEach(this::repeatPlayerHit);
        outputView.printNewLine();
        repeatDealerHit();
        outputView.printScoreResult(dealer, players.getPlayers());
        Result gameResult = players.getResult(dealer);
        outputView.printGameResult(gameResult);
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
            player.drawCard();
        }
        outputView.printPlayerHand(player);
        outputView.printNewLine();
        return hitDecision;
    }

    public void repeatDealerHit() {
        while (dealer.isHitPossible()) {
            dealer.drawCard();
            outputView.dealerHitComment();
        }
    }
}
