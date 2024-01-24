package blackjack.domain;

import java.util.ArrayList;

public class Dealer {
    private final Person dealer = new Person();

    public void initDeal(Deck deck) {
        dealer.initDeal(deck);
    }

    public void drawCard(Deck deck) {
        dealer.drawCard(deck);
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