package dto;

import java.util.List;

public class PlayerDto {

    private String playerName;
    private List<CardDto> playerCards;
    private int sumOfCards;


    public PlayerDto(String playerName, List<CardDto> playerCards, int sumOfCards) {
        this.playerName = playerName;
        this.playerCards = playerCards;
        this.sumOfCards = sumOfCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<CardDto> getPlayerCards() {
        return playerCards;
    }

    public int getSumOfCards() {
        return sumOfCards;
    }
}
