package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.GameConstant;
import java.util.ArrayList;

public class Dealer {
    private final Person person = new Person();

    public void initDeal(Deck deck) {
        person.initDeal(deck);
    }

    public void drawCard(Deck deck) {
        person.drawCard(deck);
    }

    public void addCardToHand(Card card) {
        person.addCardToHand(card);
    }

    public boolean isHitPossible() {
        return person.isHitPossible(GameConstant.DEALER_STAND_SCORE);
    }

    public int calculateTotalScore() {
        return person.calculateTotalScore();
    }

    public boolean isBlackjack() {
        return person.isBlackjack();
    }

    public ArrayList<Card> getHand() {
        return person.getHand();
    }
}