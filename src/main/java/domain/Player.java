package domain;

import java.util.List;

public class Player {

    private final OwnCards ownCards = new OwnCards();
    private final Score score = new Score();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void setFirstCards(Deck deck) {
        ownCards.getRandomTwoCards(deck);
    }

    public String getName() {
        return name;
    }

    public void pickCard(Deck deck) {
        ownCards.addCard(deck);
    }

    public List<Card> getOwnCards() {
        return ownCards.getOwnCards();
    }

    public int getSumOfCards() {
        return ownCards.getSumOfCards();
    }

    public void increaseWinCount() {
        score.increaseWinCount();
    }

    public void increaseDrawCount() {
        score.increaseDrawCount();
    }

    public void increaseLoseCount() {
        score.increaseLoseCout();
    }

    public String getBattleResult() {
        if (score.getWinCount() == 1) {
            return "승";
        }
        if (score.getLoseCount() == 1) {
            return "패";
        }
        return "무";
    }
}
