package src.main.java.domain.player;

import src.main.java.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private WinCount wins;
    private LossCount losses;
    private DrawCount draws;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.wins = new WinCount();
        this.losses = new LossCount();
        this.draws = new DrawCount();
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

    public void incrementWins() {
        wins.increment();
    }

    public void incrementLosses() {
        losses.increment();
    }

    public void incrementDraws() {
        draws.increment();
    }

    public int getWins() {
        return wins.getCount();
    }

    public int getLosses() {
        return losses.getCount();
    }

    public int getDraws() {
        return draws.getCount();
    }
}