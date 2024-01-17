package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Deck {

    private List<Card> cardList;
    private final Random random = new Random();

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        cardList = new ArrayList<>();
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        Stream.of(suits)
                .flatMap(suit -> Stream.of(ranks).map(rank -> new Card(suit, rank)))
                .forEach(cardList::add);
    }

    public Card getRandomCard() {
        return cardList.remove(random.nextInt(cardList.size()));
    }
}
