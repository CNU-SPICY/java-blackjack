package src.main.java.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    private Suit suit;
    private String rank;

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        if ("A".equals(rank)) {
            return 1; // 에이스의 디폹트값을 1로 설정
        }
        if ("K".equals(rank) || "Q".equals(rank) || "J".equals(rank)) {
            return 10;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return rank + suit.name().charAt(0);
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