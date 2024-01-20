package src.main.java.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = new Rank(rank);
    }

    public int getValue() {
        String rankValue = rank.toString();
        if ("A".equals(rankValue)) {
            return 1; // 에이스의 디폹트값을 1로 설정
        }
        if ("K".equals(rankValue) || "Q".equals(rankValue) || "J".equals(rankValue)) {
            return 10;
        }
        return Integer.parseInt(rankValue);
    }

    @Override
    public String toString() {
        return rank.toString() + suit.getName();
    }

    static List<Card> initializeDeck() {
        List<Card> newDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 2; i <= 10; i++) {
                newDeck.add(new Card(suit, String.valueOf(i)));
            }
            newDeck.add(new Card(suit, "A"));
            newDeck.add(new Card(suit, "K"));
            newDeck.add(new Card(suit, "Q"));
            newDeck.add(new Card(suit, "J"));
        }
        Collections.shuffle(newDeck);
        return newDeck;
    }
}