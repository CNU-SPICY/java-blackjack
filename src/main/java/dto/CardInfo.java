package dto;

public class CardInfo {

    private String cardRank;
    private String cardSuit;

    public CardInfo(String cardRank, String cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public String getCardRank() {
        return cardRank;
    }

    public String getCardSuit() {
        return cardSuit;
    }
}
