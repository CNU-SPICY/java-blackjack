package blackjack.domain.util;

import blackjack.domain.card.Deck;
import java.util.Random;

public class RandomGenerator {

    private final Deck deck;

    public RandomGenerator(Deck deck) {
        this.deck = deck;
    }

    public int generate() {
        Random random = new Random();
        return random.nextInt(deck.getSizeOfDeck());
    }
}
