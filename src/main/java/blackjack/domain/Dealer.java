package blackjack.domain;

import blackjack.domain.card.Deck;
import blackjack.domain.util.RandomGenerator;
import java.util.stream.IntStream;

public class Dealer extends Player {

    public static final int INITIAL_CARD_AMOUNT = 2;
    public static final int HIT_BOUND = 16;
    private static final String DEALER_NAME = "딜러";

    private final Deck deck;

    public Dealer(Deck deck) {
        super(DEALER_NAME);
        this.deck = deck;
    }

    public void giveInitialCard(Players players) {
        IntStream.range(0, INITIAL_CARD_AMOUNT).forEach(i -> {
            this.giveCardToPlayer(this);
            players.getPlayers().forEach(this::giveCardToPlayer);
        });
    }

    public boolean giveCardToPlayer(Player player) {
        RandomGenerator randomGenerator = new RandomGenerator(deck);
        return player.pickCard(deck, randomGenerator.generate());
    }

    public void decideResultAll(Players players) {
        Referee referee = new Referee();
        players.getPlayers().forEach(player -> referee.decideResult(this, player));
    }

    @Override
    public boolean isHittable() {
        return super.getScore() <= HIT_BOUND;
    }
}