package domain.person;

import domain.cards.Deck;
import domain.logics.BettingLogic;
import dto.CardDto;
import dto.DealerDto;
import java.util.List;
import java.util.Map;

public class Dealer {

    private final Participant participant;
    private Money money;

    private Dealer(final Participant participant) {
        this.participant = participant;
        this.money = Money.zero();
    }

    public static Dealer create(final String name) {
        return new Dealer(new Participant(name));
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

    public void fightBeforeDistribution(Players players) {
        for (Player player : players.getPlayers()) {
            BettingLogic.battleBeforeDistribution(this, player);
        }
    }

    public void fightEveryPlayer(Players players, Map<Player, Money> initPlayersBettingInfo) {
        BettingLogic.battle(this, players, initPlayersBettingInfo);
    }

    public void earnMoney(Money money) {
        money = money.add(money);
    }

    public void loseMoney(Money money) {
        money = money.subtract(money);
    }

    public void resetMoney(Money initMoney) {
        money = initMoney;
    }

    public DealerDto getDealerInfo() {
        return new DealerDto(getName(), getOwnCardsRankAndSuit(), getSumOfCards());
    }
}
