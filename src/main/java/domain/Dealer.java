package domain;

import java.util.List;

public class Dealer {

    private final OwnCards ownCards = new OwnCards();
    private final WinLogic winLogic = new WinLogic();
    private String name;
    private Score score;

    public Dealer(String name) {
        this.name = name;
    }

    public void setFirstCards(Deck deck) {
        ownCards.getRandomTwoCards(deck);
    }

    public String getName() {
        return name;
    }

    public List<Card> getOwnCards() {
        return ownCards.getOwnCards();
    }

    public int getSumOfCards() {
        return ownCards.getSumOfCards();
    }

    public void pickCard(Deck deck) {
        ownCards.addCard(deck);
    }

    public void fightEveryPlayer(Players players) {
        for (Player player : players.getPlayers()) {
            winLogic.battle(this, player);
        }
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
}
