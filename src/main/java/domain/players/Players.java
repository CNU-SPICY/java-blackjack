package src.main.java.domain.players;

import src.main.java.domain.card.Card;
import src.main.java.domain.player.Dealer;
import src.main.java.domain.player.Player;
import src.main.java.domain.players.WinLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Players {

    private final WinLogic winLogic = new WinLogic();
    private List<Player> players;
    private List<Card> deck;

    public Players(String[] playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        deck = Card.initializeDeck();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getPlayersNames() {
        List<String> playersNames = new ArrayList<>();
        for (Player player : players) {
            playersNames.add(player.getName());
        }
        return playersNames;
    }

    public Card drawCard() {
        return deck.remove(0);
    }

    public void startGame(Dealer dealer) {
        for (Player player : players) {
            for (int i = 0; i < 2; i++) {
                player.receiveCard(drawCard());
            }
        }
        for (int i = 0; i < 2; i++) {
            dealer.receiveCard(drawCard());
        }
    }

    public void playPlayerTurn(Player player) {
        player.receiveCard(drawCard());
    }

    public void playDealerTurn(Dealer dealer) {
        while (dealer.dealerShouldReceiveCard()) {
            dealer.receiveCard(drawCard());
            dealer.dealerReceivedCard();
        }
    }

    public void determineWinners(Dealer dealer) {
        for (Player player : players) {
            winLogic.determineWinner(player, dealer);
        }
    }
}