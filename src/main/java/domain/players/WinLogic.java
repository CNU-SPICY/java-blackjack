package src.main.java.domain.players;

import src.main.java.domain.player.Dealer;
import src.main.java.domain.player.Player;

public class WinLogic {

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
        return playerScore <= 21 && (playerScore > dealerScore || dealerScore > 21);
    }

    private boolean isDealerWin(int playerScore, int dealerScore) {
        return dealerScore <= 21 && (dealerScore > playerScore || playerScore > 21);
    }

    private boolean isDraw(int playerScore, int dealerScore) {
        return playerScore <= 21 && playerScore == dealerScore;
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