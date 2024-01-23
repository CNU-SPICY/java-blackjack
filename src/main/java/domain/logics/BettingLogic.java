package domain.logics;

import domain.person.Dealer;
import domain.person.Money;
import domain.person.Player;

public class BettingLogic {

    public void battleBeforeDistribution(Dealer dealer, Player player) {
        if (dealer.isBlackJack() && !player.isBlackJack()) {
            dealerWin(dealer, player);
        }
        if (!dealer.isBlackJack() && player.isBlackJack()) {
            playerWin(dealer, player);
        }
    }

    public void battle(Dealer dealer, Player player) {
        if (dealer.isBust()) {
            handleDealerBiggerThenStandardNumber(dealer, player);
            return;
        }
        handleDealerSmallerThenStandardNumber(dealer, player);
    }

    private void handleDealerBiggerThenStandardNumber(Dealer dealer, Player player) {
        if (!player.isBust()) {
            playerWin(dealer, player);
            return;
        }
        draw(dealer, player);
    }

    private void handleDealerSmallerThenStandardNumber(Dealer dealer, Player player) {
        if (player.isBust()) {
            dealerWin(dealer, player);
            return;
        }
        compareDealerAndPlayer(dealer, player);
    }

    private void compareDealerAndPlayer(Dealer dealer, Player player) {
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
        dealer.increaseWinCount();
        player.loseMoney();
        dealer.earnMoney(Money.create(player.getMoney()));
    }

    private void playerWin(Dealer dealer, Player player) {
        player.increaseWinCount();
        dealer.increaseLoseCount();
        player.earnMoney();
        dealer.loseMoney(Money.create(player.getMoney()));
    }

    private void draw(Dealer dealer, Player player) {
        dealer.increaseDrawCount();
        player.increaseDrawCount();
    }
}