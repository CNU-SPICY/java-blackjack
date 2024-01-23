package dto;

import java.util.List;

public class PlayerDto {

    private String playerName;
    private List<CardDto> playerCards;
    private int sumOfCards;
    private int money;

    public PlayerDto(String playerName, List<CardDto> playerCards, int sumOfCards, double money) {
        this.playerName = playerName;
        this.playerCards = playerCards;
        this.sumOfCards = sumOfCards;
        this.money = (int) money;
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

    public double getMoney() {
        return money;
    }
}
