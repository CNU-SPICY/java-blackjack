package dto;

import java.util.List;

public class DealerInfo {

    private String dealerName;
    private List<CardInfo> dealerCards;
    private int sumOfCards;

    public DealerInfo(String dealerName, List<CardInfo> dealerCards, int sumOfCards) {
        this.dealerName = dealerName;
        this.dealerCards = dealerCards;
        this.sumOfCards = sumOfCards;
    }

    public String getDealerName() {
        return dealerName;
    }

    public List<CardInfo> getDealerCards() {
        return dealerCards;
    }

    public int getSumOfCards() {
        return sumOfCards;
    }
}
