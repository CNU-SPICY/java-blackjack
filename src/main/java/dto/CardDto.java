package dto;

public class CardDto {

    private String cardRank;
    private String cardSuit;

    public CardDto(String cardRank, String cardSuit) {
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
