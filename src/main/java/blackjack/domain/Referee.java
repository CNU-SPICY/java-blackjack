package blackjack.domain;

public class Referee {

    private static final float BLACKJACK_MONEY_RATE = 1.5f;

    public void decideResult(Dealer dealer, Player player) {
        int result = compareScore(dealer, player);
        if (isDealerWin(result)) {
            dealer.addProfit( player.getBetting());
            player.addProfit(-player.getBetting());
            return;
        }
        if(isBlackjack(result, player)) {
            dealer.addProfit((int) (-player.getBetting() * BLACKJACK_MONEY_RATE));
            player.addProfit((int) ( player.getBetting() * BLACKJACK_MONEY_RATE));
            return;
        }
        if (isPlayerWin(result)) {
            dealer.addProfit(-player.getBetting());
            player.addProfit( player.getBetting());
        }
    }

    private int compareScore(Dealer dealer, Player player) {
        if (player.isBust()) {
            return 1;
        }
        if (dealer.isBust()) {
            return -1;
        }
        return dealer.getScore() - player.getScore();
    }

    private boolean isDealerWin(int result) {
        return result > 0;
    }

    private boolean isBlackjack(int result, Player player) {
        return isPlayerWin(result) && player.getScore() == 21 && player.getCardsAmount() == 2;
    }

    private boolean isPlayerWin(int result) {
        return result < 0;
    }
}
