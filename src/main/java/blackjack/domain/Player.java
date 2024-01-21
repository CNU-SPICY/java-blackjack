package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.PlayerCards;
import blackjack.domain.result.GameResult;
import java.util.List;

public class Player {

    private final String name;
    private final PlayerCards cards;
    private GameResult gameResult;

    public Player(String name) {
        this.name = name;
        this.cards = new PlayerCards();
    }

    public boolean pickCard(Deck deck, int random) {
        if (isHittable()) {
            cards.addCard(deck.popCard(random));
            return true;
        }
        return false;
    }

    public boolean isHittable() {
        return getScore() < PlayerCards.DEAD_LINE;
    }

    public boolean isBust() {
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
}