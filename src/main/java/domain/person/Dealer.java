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

    public void earnMoney(Money addedMoney) {
        money = money.add(addedMoney);
    }

    public void loseMoney(Money subtractedMoney) {
        money = money.subtract(subtractedMoney);
    }

    public void resetMoney(Money initMoney) {
        money = initMoney;
    }

    public DealerDto getDealerDto() {
        return new DealerDto(getName(), getOwnCardsRankAndSuit(), getSumOfCards(), getMoney());
    }

    public double getMoney() {
        return money.getMoney();
    }
}
