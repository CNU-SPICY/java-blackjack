package domain.logics;

import domain.person.Dealer;
import domain.person.Player;

public class BettingLogic {

    private static final int STANDARD_NUMBER = 21;

    public void battle(Dealer dealer, Player player) {
        if (dealer.getSumOfCards() > STANDARD_NUMBER) {
            handleDealerBiggerThenStandardNumber(dealer, player);
            return;
        }
        handleDealerSmallerThenStandardNumber(dealer, player);
    }

    private void handleDealerBiggerThenStandardNumber(Dealer dealer, Player player) {
        if (player.getSumOfCards() <= STANDARD_NUMBER) {
            playerWin(dealer, player);
            return;
        }
        draw(dealer, player);
    }

    private void handleDealerSmallerThenStandardNumber(Dealer dealer, Player player) {
        if (player.getSumOfCards() > STANDARD_NUMBER) {
            dealerWin(dealer, player);
            return;
        }
        compareDealerAndHandler(dealer, player);
    }

    private void compareDealerAndHandler(Dealer dealer, Player player) {
        if (dealer.getSumOfCards() > player.getSumOfCards()) {
            dealerWin(dealer, player);
            return;
        }
        if (dealer.getSumOfCards() == player.getSumOfCards()) {
            draw(dealer, player);
            return;
        }
        if (dealer.getSumOfCards() < player.getSumOfCards()) {
            playerWin(dealer, player);
        }
    }

    private void dealerWin(Dealer dealer, Player player) {
        player.increaseLoseCount();
        player.loseMoney();
        dealer.increaseWinCount();
    }

    private void playerWin(Dealer dealer, Player player) {
        player.increaseWinCount();
        dealer.increaseLoseCount();
    }

    private void draw(Dealer dealer, Player player) {
        dealer.increaseDrawCount();
        player.increaseDrawCount();
    }
}