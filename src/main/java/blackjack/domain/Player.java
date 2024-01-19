package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.PlayerCards;
import blackjack.domain.enums.GameResult;
import java.util.List;

public class Player implements Comparable<Player> {

    private final String name;
    private final PlayerCards cards;
    private GameResult gameResult;

    public Player(String name) {
        this.name = name;
        this.cards = new PlayerCards();
    }

    public boolean pickCard(Deck deck, int random) {
        if (canPickCard()) {
            cards.pickCard(deck.popCard(random));
            return true;
        }
        return false;
    }

    public boolean canPickCard() {
        return getScore() < PlayerCards.DEAD_LINE;
    }

    public boolean isDead() {
        return getScore() > PlayerCards.DEAD_LINE;
    }

    public int getScore() {
        return cards.calcScore();
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

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards.getCards();
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
        return this.getScore() - other.getScore();
    }
}
