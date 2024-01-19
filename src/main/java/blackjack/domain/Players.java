package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int BUST_SCORE = 22;
    private final ArrayList<Player> players = new ArrayList<>();

    public Players(List<String> playerNames) {
        for(String name : playerNames) {
            players.add(new Player(name));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void initDeal() {
        for(Player player : players) {
            player.initDeal();
        }
    }

    public Result getResult(Dealer dealer) {
        Result result = new Result();
        int dealerScore = dealer.calculateTotalScore();
        for(Player player : players) {
            int playerScore = player.calculateTotalScore();
            String playerResult = decidePlayerResult(dealerScore, playerScore);
            result.addPlayerResult(player.getName(), playerResult);
        }
        return result;
    }

    public String decidePlayerResult(int dealerScore, int playerScore) {
        if(playerScore >= BUST_SCORE) {
            return "패";
        }
        if(dealerScore >= BUST_SCORE) {
            return "승";
        }
        if(playerScore > dealerScore) {
            return "승";
        }
        if(dealerScore > playerScore) {
            return "패";
        }
        return "무";
    }}
