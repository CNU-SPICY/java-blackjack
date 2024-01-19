package blackjack.domain;

import java.util.ArrayList;

public class Dealer {
    private static final int STAND_SCORE = 17;
    private static final int BUST_SCORE = 22;
    private final ArrayList<Card> hand = new ArrayList<>();
    private RandomCardGenerator randomCardGenerator = new RandomCardGenerator();

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void initDeal() {
        drawCard();
        drawCard();
    }

    public void drawCard() {
        addCardToHand(randomCardGenerator.drawRandomCard());
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public boolean isHitPossible() {
        return (calculateTotalScore() < STAND_SCORE);
    }

    public int calculateTotalScore() {
        int totalScore = hand.stream()
                .mapToInt(Card::getScore)
                .sum();
        long aceCount = countAce();
        while(aceCount > 0 && totalScore >= BUST_SCORE) {
            totalScore -= 10;
            aceCount --;
        }
        return totalScore;
    }

    private long countAce() {
        return hand.stream()
                .filter(this::isAce)
                .count();
    }

    private boolean isAce(Card card) {
        String cardInfo = card.getInfo();
        return cardInfo.contains("A");
    }
}
