package domain.cards;

import domain.cards.constant.CardEnums.CardRank;
import domain.cards.constant.CardEnums.CardSuit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Deck {

    private final Random random = new Random();
    private List<Card> cardList;

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        cardList = new ArrayList<>();
        CardSuit[] suits = CardSuit.values();
        CardRank[] ranks = CardRank.values();

        Stream.of(suits)
                .flatMap(suit -> Stream.of(ranks).map(rank -> new Card(suit, rank)))
                .forEach(cardList::add);
    }

    public Card getRandomCard() {
        return cardList.remove(random.nextInt(cardList.size()));
    }
}
