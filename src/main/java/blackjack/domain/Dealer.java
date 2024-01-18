package blackjack.domain;

import blackjack.domain.util.RandomGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Dealer extends Player {

    public static final int INITIAL_CARD_AMOUNT = 2;
    private static final int PICKUP_BOUND = 16;
    private static final String DEALER_NAME = "딜러";

    private final RandomGenerator randomGenerator;
    private final Deck deck;
    private final List<GameResult> gameResults;

    public Dealer(Deck deck) {
        super(DEALER_NAME);
        this.randomGenerator = new RandomGenerator(deck);
        this.deck = deck;
        this.gameResults = new ArrayList<>();
    }

    public void giveInitialCard(Players players) {
        IntStream.range(0, INITIAL_CARD_AMOUNT).forEach(i -> {
            this.giveCardToPlayer(this);
            players.getPlayers().forEach(this::giveCardToPlayer);
        });
    }

    public boolean giveCardToPlayer(Player player) {
        return player.pickCard(deck, randomGenerator.generate());
    }

    public void decideResultOfAll(Players players) {
        players.getPlayers().forEach(this::decideResult);
    }

    private void decideResult(Player player) {
        int result = this.compareTo(player);
        if (result > 0) {
            gameResults.add(GameResult.WIN);
            player.setResultToLose();
            return;
        }
        if (result < 0) {
            gameResults.add(GameResult.LOSE);
            player.setResultToWin();
            return;
        }
        gameResults.add(GameResult.DRAW);
        player.setResultToDraw();
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    @Override
    public boolean canPickCard() {
        return calcScore() <= PICKUP_BOUND;
    }
}
