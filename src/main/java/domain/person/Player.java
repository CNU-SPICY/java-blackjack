package domain.person;

import domain.cards.Deck;
import domain.cards.OwnCards;
import domain.logics.Score;
import domain.person.wrapper.NameWrapper;
import dto.CardInfo;
import dto.PlayerInfo;
import java.util.List;

public class Player {

    private final OwnCards ownCards = new OwnCards();
    private final Score score = new Score();
    private final NameWrapper name;

    public Player(NameWrapper name) {
        this.name = name;
    }

    public void setFirstCards(Deck deck) {
        ownCards.getRandomTwoCards(deck);
    }

    public String getName() {
        return name.getName();
    }

    public void pickCard(Deck deck) {
        ownCards.addCard(deck);
    }

    public List<CardInfo> getOwnCardsRankAndSuit() {
        return ownCards.getRankAndSuit();
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

    public int getBattleResult() {
        if (score.getWinCount() == 1) {
            return 1;
        }
        if (score.getLoseCount() == 1) {
            return -1;
        }
        return 0;
    }

    public PlayerInfo getPlayerInfo() {
        return new PlayerInfo(getName(), getOwnCardsRankAndSuit(), getSumOfCards());
    }
}
