package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.GameConstant;
import java.util.ArrayList;

public class Player {
    private final Name name;
    private final Person person;

    public Player(String name) {
        this.name = new Name(name);
        person = new Person();
    }

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
        return person.isHitPossible(GameConstant.BUST_SCORE);
    }

    public int calculateTotalScore() {
        return person.calculateTotalScore();
    }

    public String decidePlayerResult(Dealer dealer) {
        int dealerScore = dealer.calculateTotalScore();
        int playerScore = person.calculateTotalScore();
        if (person.isBlackjack() && !dealer.isBlackjack()) {
            return GameConstant.BLACKJACK;
        }
        if (playerScore >= GameConstant.BUST_SCORE) {
            return GameConstant.LOSE;
        }
        if (dealerScore >= GameConstant.BUST_SCORE) {
            return GameConstant.WIN;
        }
        if (playerScore > dealerScore) {
            return GameConstant.WIN;
        }
        if (dealerScore > playerScore) {
            return GameConstant.LOSE;
        }
        return GameConstant.PUSH;
    }

    public boolean isBlackjack() {
        return person.isBlackjack();
    }

    public Name getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return person.getHand();
    }
}