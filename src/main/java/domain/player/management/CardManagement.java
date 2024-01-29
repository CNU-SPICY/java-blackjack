package src.main.java.domain.player.management;

import src.main.java.domain.card.Card;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CardManagement {
    private List<Card> hand = new ArrayList<>();

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public int calculateScore() {
        int score = 0;
        int aceCount = 0;

        for (Card card : hand) {
            int cardValue = card.getValue();
            score += cardValue;
            if (cardValue == 1) {
                aceCount++;
            }
        }
        while (aceCount > 0 && score <= 11) {
            score += 10;
            aceCount--;
        }
        return score;
    }

    public boolean isBlackJack() {
        return hand.size() == 2 && calculateScore() == 21;
    }

    public Map<String, List<String>> getHandDetails() {
        Map<String, List<String>> handDetails = new LinkedHashMap<>();
        for (Card card : this.hand) {
            handDetails.computeIfAbsent(card.getSuit().getName(), k -> new ArrayList<>())
                    .add(card.getRank().toString());
        }
        return handDetails;
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }
}