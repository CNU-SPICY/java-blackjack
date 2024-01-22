package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final ArrayList<Player> players = new ArrayList<>();

    public Players(List<String> playerNames) {
        for (String name : playerNames) {
            players.add(new Player(name));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void initDeal(Deck deck) {
        for (Player player : players) {
            player.initDeal(deck);
        }
    }

    public Result getResult(Dealer dealer) {
        Result result = new Result();
        int dealerScore = dealer.calculateTotalScore();
        for (Player player : players) {
            int playerScore = player.calculateTotalScore();
            String playerResult = decidePlayerResult(dealerScore, playerScore);
            result.addPlayerResult(player.getName(), playerResult);
        }
        return result;
    }

    public String decidePlayerResult(int dealerScore, int playerScore) {
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
}