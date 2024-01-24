package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.GameConstant;
import java.util.ArrayList;

public class Dealer {
    private final Person dealer = new Person();

    public void initDeal(Deck deck) {
        dealer.initDeal(deck);
    }

    public void drawCard(Deck deck) {
        dealer.drawCard(deck);
    }

    public void addCardToHand(Card card) {
        dealer.addCardToHand(card);
    }

    public boolean isHitPossible() {
        return dealer.isHitPossible(GameConstant.DEALER_STAND_SCORE);
    }

    public int calculateTotalScore() {
        return dealer.calculateTotalScore();
    }

    public boolean isBlackjack() {
        return dealer.isBlackjack();
    }

    public ArrayList<Card> getHand() {
        return dealer.getHand();
    }
}