package src.main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int wins;
    private int losses;
    private int draws;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public String handToString() {
        List<String> cardStrings = new ArrayList<>();
        for (Card card : hand) {
            cardStrings.add(card.toString());
        }
        return String.join(", ", cardStrings);
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : hand) {
            score += card.getValue();
            if (card.getValue() == 1) {
                numAces++;
            }
        }
        while (numAces > 0 && score <= 11) {
            score += 10;
            numAces--;
        }
        return score;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    public void incrementDraws() {
        draws++;
    }
}