package blackjack.domain.person;

import blackjack.domain.card.Deck;
import blackjack.domain.GameConstant;
import blackjack.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final ArrayList<Player> players = new ArrayList<>();

    public Players(List<String> playerNames) {
        for (String name : playerNames) {
            players.add(new Player(name));
        }
    }

    public void initDeal(Deck deck) {
        for (Player player : players) {
            player.initDeal(deck);
        }
    }

    public Result updateResult(Dealer dealer, Result result) {
        for (Player player : players) {
            String playerResult = decidePlayerResult(dealer, player);
            result.updateBetAmount(player.getName(), playerResult);
        }
        return result;
    }

    public String decidePlayerResult(Dealer dealer, Player player) {
        int dealerScore = dealer.calculateTotalScore();
        int playerScore = player.calculateTotalScore();
        if (player.isBlackjack() && !dealer.isBlackjack()) {
            return GameConstant.BLACKJACK;
        }
        if (playerScore >= GameConstant.BUST_SCORE) {
            return GameConstant.LOSE;
        }
        if (dealerScore >= GameConstant.BUST_SCORE) {
            return GameConstant.WIN;
        }
        if (playerScore > dealerScore) {
            return GameConstant.WIN;
        }
        if (dealerScore > playerScore) {
            return GameConstant.LOSE;
        }
        return GameConstant.PUSH;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}