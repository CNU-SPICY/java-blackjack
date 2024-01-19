package blackjack.domain;

public class CardData {
    private final String[] cardDenomination = {"A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final String[] cardSuit = {"스페이드", "다이아몬드", "하트", "클로버"};

    public String indexToDenomination(int index) {
        return cardDenomination[index];
    }

    public String indexToSuit(int index) {
        return cardSuit[index];
    }

    public int indexToScore(int index) {
        if(index == 0) {
            return 11;
        }
        if(index <= 9) {
            return (index) + 1;
        }
        return 10;
    }
}
