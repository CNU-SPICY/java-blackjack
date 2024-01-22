package domain.person;

import domain.cards.Deck;
import domain.cards.OwnCards;
import domain.logics.Score;
import domain.logics.WinLogic;
import domain.person.wrapper.NameWrapper;
import dto.CardInfo;
import dto.DealerInfo;
import java.util.List;

public class Dealer {

    private final OwnCards ownCards = new OwnCards();
    private final WinLogic winLogic = new WinLogic();
    private final Score score = new Score();
    private final NameWrapper name;

    public Dealer(NameWrapper name) {
        this.name = name;
    }

    public void setFirstCards(Deck deck) {
        ownCards.getRandomTwoCards(deck);
    }

    public String getName() {
        return name.getName();
    }

    public int getSumOfCards() {
        return ownCards.getSumOfCards();
    }

    public void pickCard(Deck deck) {
        ownCards.addCard(deck);
    }

    public List<CardInfo> getOwnCardsRankAndSuit() {
        return ownCards.getRankAndSuit();
    }

    public void fightEveryPlayer(Players players) {
        for (Player player : players.getPlayers()) {
            winLogic.battle(this, player);
        }
    }

    public DealerInfo getDealerInfo() {
        return new DealerInfo(getName(), getOwnCardsRankAndSuit(), getSumOfCards());
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

    public int getWinCount() {
        return score.getWinCount();
    }

    public int getDrawCount() {
        return score.getDrawCount();
    }

    public int getLoseCount() {
        return score.getLoseCount();
    }
}
