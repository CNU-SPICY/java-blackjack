package blackjack.domain;

public class Referee {

    private static final float BLACKJACK_MONEY_RATE = 1.5f;
    private static final int STATE_DEALER_WIN = 1;
    private static final int STATE_PUSH = 0;
    private static final int STATE_PLAYER_WIN = -STATE_DEALER_WIN;

    public void decideResult(Dealer dealer, Player player) {
        int result = resultState(dealer, player);
        if (isDealerWin(result)) {
            dealer.addProfit( player.getBetting());
            player.addProfit(-player.getBetting());
            return;
        }
        if (isBlackjack(result, player)) {
            dealer.addProfit((int) (-player.getBetting() * BLACKJACK_MONEY_RATE));
            player.addProfit((int) ( player.getBetting() * BLACKJACK_MONEY_RATE));
            return;
        }
        if (isPlayerWin(result)) {
            dealer.addProfit(-player.getBetting());
            player.addProfit( player.getBetting());
        }
    }

    private int resultState(Dealer dealer, Player player) {
        if (player.isBust()) {
            return STATE_DEALER_WIN;
        }
        if (dealer.isBust()) {
            return STATE_PLAYER_WIN;
        }
        if (dealer.getScore() > player.getScore()) {
            return STATE_DEALER_WIN;
        }
        if (dealer.getScore() < player.getScore()) {
            return STATE_PLAYER_WIN;
        }
        return STATE_PUSH;
    }

    private boolean isDealerWin(int result) {
        return result == STATE_DEALER_WIN;
    }

    private boolean isBlackjack(int result, Player player) {
        return isPlayerWin(result) && player.getScore() == 21 && player.getCardsAmount() == 2;
    }

    private boolean isPlayerWin(int result) {
        return result == STATE_PLAYER_WIN;
    }
}
