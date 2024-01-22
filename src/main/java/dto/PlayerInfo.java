package dto;

import java.util.List;

public class PlayerInfo {

    private String playerName;
    private List<CardInfo> playerCards;
    private int sumOfCards;


    public PlayerInfo(String playerName, List<CardInfo> playerCards, int sumOfCards) {
        this.playerName = playerName;
        this.playerCards = playerCards;
        this.sumOfCards = sumOfCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<CardInfo> getPlayerCards() {
        return playerCards;
    }

    public int getSumOfCards() {
        return sumOfCards;
    }
}
