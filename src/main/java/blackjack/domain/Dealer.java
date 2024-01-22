package blackjack.domain;

import blackjack.domain.card.Deck;
import blackjack.domain.result.GameResult;
import blackjack.domain.result.GameResults;
import blackjack.domain.util.RandomGenerator;
import java.util.List;
import java.util.stream.IntStream;

public class Dealer extends Player {

    public static final int INITIAL_CARD_AMOUNT = 2;
    public static final int HIT_BOUND = 16;
    private static final String DEALER_NAME = "딜러";

    private final Deck deck;
    private final GameResults gameResults;

    public Dealer(Deck deck) {
        super(DEALER_NAME);
        this.deck = deck;
        this.gameResults = new GameResults();
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

    public void addWinToResults() {
        gameResults.addWin();
    }

    public void addLoseToResults() {
        gameResults.addLose();
    }

    public void addDrawToResults() {
        gameResults.addDraw();
    }

    public int getWinCount() {
        return gameResults.getWinCount();
    }

    public int getLoseCount() {
        return gameResults.getLoseCount();
    }

    public int getDrawCount() {
        return gameResults.getDrawCount();
    }

    public List<GameResult> getGameResults() {
        return gameResults.getGameResults();
    }

    @Override
    public boolean isHittable() {
        return super.getScore() <= HIT_BOUND;
    }
}