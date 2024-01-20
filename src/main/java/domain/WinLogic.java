package src.main.java.domain;

public class WinLogic {

    public void determineWinner(Player player, Dealer dealer) {
        int dealerScore = dealer.calculateScore();
        int playerScore = player.calculateScore();

        if (dealerScore > 21 || playerScore <= 21 && playerScore > dealerScore) {
            dealer.incrementLosses();
            player.incrementWins();
        } else if (playerScore > 21 || (dealerScore <= 21 && dealerScore > playerScore)) {
            dealer.incrementWins();
            player.incrementLosses();
        } else if (playerScore <= 21 && playerScore == dealerScore) {
            dealer.incrementDraws();
            player.incrementDraws();
        }
    }
}