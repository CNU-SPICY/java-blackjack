package domain.person;

import domain.cards.Deck;
import domain.logics.EarnMoneyLogic;
import dto.CardDto;
import dto.PlayerDto;
import java.util.List;

public class Player {

    private final Participant participant;

    private Money money;

    private Player(final Participant participant) {
        this.participant = participant;
    }

    public static Player create(final String name) {
        return new Player(new Participant(name));
    }

    public void betting(final Money money) {
        this.money = money;
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

    public void earnMoney() {
        money = EarnMoneyLogic.WIN.calculateMoney(money);
    }

    public void loseMoney() {
        money = EarnMoneyLogic.LOSE.calculateMoney(money);
    }

    public void bonusMoney() {
        money = EarnMoneyLogic.BONUS.calculateMoney(money);
    }

    public PlayerDto getPlayerInfo() {
        return new PlayerDto(getName(), getOwnCardsRankAndSuit(), getSumOfCards());
    }

    public void resetMoney(Money initMoney) {
        money = initMoney;
    }

    public double getMoney() {
        return money.getMoney();
    }
}
