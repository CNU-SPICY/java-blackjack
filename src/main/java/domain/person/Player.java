package domain.person;

import domain.cards.Card;
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

    public void setFirstCards(Card firstCard, Card secondCard) {
        participant.setFirstCards(firstCard, secondCard);
    }

    public String getName() {
        return participant.getName();
    }

    public void pickCard(Card card) {
        participant.pickCard(card);
    }

    public List<CardDto> getOwnCardsRankAndSuit() {
        return participant.getOwnCardsRankAndSuit();
    }

    public int getSumOfCards() {
        return participant.getSumOfCards();
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
        return new PlayerDto(getName(), getOwnCardsRankAndSuit(), getSumOfCards(), getMoney());
    }

    public void resetMoney(Money initMoney) {
        money = initMoney;
    }

    public double getMoney() {
        return money.getMoney();
    }
}
