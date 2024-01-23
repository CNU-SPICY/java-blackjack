package domain.person;

import domain.cards.Deck;
import dto.CardDto;
import dto.PlayerDto;
import java.util.List;

public class Player {

    private final Participant participant;

    private Player(final Participant participant) {
        this.participant = participant;
    }

    public static Player create(final String name) {
        return new Player(new Participant(name));
    }

    public void setFirstCards(Deck deck) {
        participant.setFirstCards(deck);
    }

    public String getName() {
        return participant.getName();
    }

    public void pickCard(Deck deck) {
        participant.pickCard(deck);
    }

    public List<CardDto> getOwnCardsRankAndSuit() {
        return participant.getOwnCardsRankAndSuit();
    }

    public int getSumOfCards() {
        return participant.getSumOfCards();
    }

    public void increaseWinCount() {
        participant.increaseWinCount();
    }

    public void increaseDrawCount() {
        participant.increaseDrawCount();
    }

    public void increaseLoseCount() {
        participant.increaseLoseCount();
    }

    public int getBattleResult() {
        return participant.getBattleResult();
    }

    public boolean isBust() {
        return participant.isBust();
    }

    public boolean isBlackJack() {
        return participant.isBlackJack();
    }

    public PlayerDto getPlayerInfo() {
        return new PlayerDto(getName(), getOwnCardsRankAndSuit(), getSumOfCards());
    }
}
