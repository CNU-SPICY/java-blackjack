package src.main.java.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";
    private static final int MIN_RANK = 2;
    private static final int MAX_RANK = 10;

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = new Rank(rank);
    }

    public int getValue() {
        String rankValue = rank.toString();
        if (ACE.equals(rankValue)) {
            return 1; // 에이스의 디폴트 값 설정
        }
        if (KING.equals(rankValue) || QUEEN.equals(rankValue) || JACK.equals(rankValue)) {
            return 10;
        }
        return Integer.parseInt(rankValue);
    }

    public static List<Card> initializeDeck() {
        List<Card> newDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = MIN_RANK; i <= MAX_RANK; i++) {
                newDeck.add(new Card(suit, String.valueOf(i)));
            }
            newDeck.add(new Card(suit, ACE));
            newDeck.add(new Card(suit, KING));
            newDeck.add(new Card(suit, QUEEN));
            newDeck.add(new Card(suit, JACK));
        }
        Collections.shuffle(newDeck);
        return newDeck;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}