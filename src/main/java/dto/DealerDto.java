package dto;

import java.util.List;

public class DealerDto {

    private String dealerName;
    private List<CardDto> dealerCards;
    private int sumOfCards;

    public DealerDto(String dealerName, List<CardDto> dealerCards, int sumOfCards) {
        this.dealerName = dealerName;
        this.dealerCards = dealerCards;
        this.sumOfCards = sumOfCards;
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
}
