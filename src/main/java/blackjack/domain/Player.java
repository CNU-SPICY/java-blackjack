package blackjack.domain;

import blackjack.domain.carddata.CardNumber;
import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {

    private static final int DEAD_LINE = 21;

    private final String name;
    private final List<Card> cards;
    private GameResult gameResult;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public boolean pickCard(Deck deck, int random) {
        if (canPickCard()) {
            cards.add(deck.popCard(random));
            return true;
        }
        return false;
    }

    public boolean canPickCard() {
        return calcScore() < DEAD_LINE;
    }

    public boolean isDead() {
        return calcScore() > DEAD_LINE;
    }

    public int calcScore() {
        final int score = cards.stream().mapToInt(Card::getNumber).sum();
        final int extra = extraScoreFromAce(score);
        return score + extra;
    }

    private int extraScoreFromAce(int score) {
        return AmountOfAceWithExtraScore(score) * CardNumber.DIFF_ACE_SCORE;
    }

    private int AmountOfAceWithExtraScore(int score) {
        int upperAmountOfAce = AmountOfAce();
        int extraAmountOfAce = (DEAD_LINE - score) / CardNumber.DIFF_ACE_SCORE;
        return Math.min(upperAmountOfAce, extraAmountOfAce);
    }

    private int AmountOfAce() {
        return (int) cards.stream().filter(card -> card.getCardNumber() == CardNumber.ACE).count();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setResultToWin() {
        gameResult = GameResult.WIN;
    }

    public void setResultToLose() {
        gameResult = GameResult.LOSE;
    }

    public void setResultToDraw() {
        gameResult = GameResult.DRAW;
    }

    public String getGameResult() {
        return gameResult.getResult();
    }

    @Override
    public int compareTo(Player other) {
        if (this.isDead() && other.isDead()) {
            return 0;
        }
        if (this.isDead()) {
            return -1;
        }
        if (other.isDead()) {
            return 1;
        }
        return this.calcScore() - other.calcScore();
    }
}
