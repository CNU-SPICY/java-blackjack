package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.PlayerCards;
import java.util.List;

public class Player {

    private final String name;
    private final PlayerCards cards;
    private final Account account;

    public Player(String name) {
        this.name = name;
        this.cards = new PlayerCards();
        this.account = new Account();
    }

    public boolean pickCard(Deck deck, int random) {
        if (isHittable()) {
            cards.addCard(deck.popCard(random));
            return true;
        }
        return false;
    }

    public boolean isHittable() {
        return getScore() < PlayerCards.DEAD_LINE;
    }

    public boolean isBust() {
        return getScore() > PlayerCards.DEAD_LINE;
    }

    public int getScore() {
        return cards.calcScore();
    }

    public String getName() {
        return name;
    }

    public int getCardsAmount() {
        return cards.getCardsAmount();
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    public void addBetting(int betting) {
        account.addBetting(betting);
    }

    public int getBetting() {
        return account.getBetting();
    }

    public void addMoney(int money) {
        account.addMoney(money);
    }

    public int getMoney() {
        return account.getMoney();
    }
}