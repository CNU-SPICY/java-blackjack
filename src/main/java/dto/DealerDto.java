package dto;

import java.util.List;

public class DealerDto {

    private String dealerName;
    private List<CardDto> dealerCards;
    private int sumOfCards;

    private int money;

    public DealerDto(String dealerName, List<CardDto> dealerCards, int sumOfCards, double money) {
        this.dealerName = dealerName;
        this.dealerCards = dealerCards;
        this.sumOfCards = sumOfCards;
        this.money = (int) money;
    }

    public String getDealerName() {
        return dealerName;
    }

    public List<CardDto> getDealerCards() {
        return dealerCards;
    }

    public int getSumOfCards() {
        return sumOfCards;
    }

    public int getMoney() {
        return money;
    }
}
