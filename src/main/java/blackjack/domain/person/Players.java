package blackjack.domain.person;

import blackjack.domain.card.Deck;
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
            String playerResult = player.decidePlayerResult(dealer);
            result.updateBetAmount(player.getName(), playerResult);
        }
        return result;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}