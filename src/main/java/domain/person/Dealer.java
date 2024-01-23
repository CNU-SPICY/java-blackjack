package domain.person;

import domain.cards.Deck;
import domain.cards.OwnCards;
import domain.logics.Score;
import domain.logics.WinLogic;
import domain.person.wrapper.ParticipantName;
import dto.CardDto;
import dto.DealerDto;
import java.util.List;

public class Dealer {

    private final OwnCards ownCards;
    private final WinLogic winLogic = new WinLogic();
    private final Score score;
    private final ParticipantName name;

    private Dealer(ParticipantName name) {
        this.name = name;
        this.ownCards = OwnCards.create();
        this.score = Score.create();
    }

    public static Dealer create(final ParticipantName name) {
        return new Dealer(name);
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

    public List<CardDto> getOwnCardsRankAndSuit() {
        return ownCards.getRankAndSuit();
    }

    public void fightEveryPlayer(Players players) {
        for (Player player : players.getPlayers()) {
            winLogic.battle(this, player);
        }
    }

    public DealerDto getDealerInfo() {
        return new DealerDto(getName(), getOwnCardsRankAndSuit(), getSumOfCards());
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
