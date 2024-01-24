package src.main.java.domain.players;

import src.main.java.domain.player.Dealer;
import src.main.java.domain.player.Player;

public class WinLogic {

    private static final int MAX_SCORE = 21;

    public void determineWinner(Player player, Dealer dealer) {
        int dealerScore = dealer.calculateScore();
        int playerScore = player.calculateScore();

        if (isPlayerWin(playerScore, dealerScore)) {
            processPlayerWin(player, dealer);
        } else if (isDealerWin(playerScore, dealerScore)) {
            processDealerWin(player, dealer);
        } else if (isDraw(playerScore, dealerScore)) {
            processDraw(player, dealer);
        }
    }

    private boolean isPlayerWin(int playerScore, int dealerScore) {
        return playerScore <= MAX_SCORE && (playerScore > dealerScore || dealerScore > MAX_SCORE);
    }

    private boolean isDealerWin(int playerScore, int dealerScore) {
        return dealerScore <= MAX_SCORE && (dealerScore > playerScore || playerScore > MAX_SCORE);
    }

    private boolean isDraw(int playerScore, int dealerScore) {
        return playerScore <= MAX_SCORE && playerScore == dealerScore;
    }

    private void processPlayerWin(Player player, Dealer dealer) {
        dealer.incrementLosses();
        player.incrementWins();
    }

    private void processDealerWin(Player player, Dealer dealer) {
        dealer.incrementWins();
        player.incrementLosses();
    }

    private void processDraw(Player player, Dealer dealer) {
        dealer.incrementDraws();
        player.incrementDraws();
    }
}