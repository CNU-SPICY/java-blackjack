package blackjack.domain;

public class Referee {

    public void decideResult(Dealer dealer, Player player) {
        int result = compareScore(dealer, player);
        if (result > 0) {
            dealer.addWinToResults();
            player.setResultToLose();
            return;
        }
        if (result < 0) {
            dealer.addLoseToResults();
            player.setResultToWin();
            return;
        }
        dealer.addDrawToResults();
        player.setResultToDraw();
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
}
