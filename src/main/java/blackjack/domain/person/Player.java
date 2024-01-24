package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.GameConstant;
import java.util.ArrayList;

public class Player {
    private final Name name;
    private final Person player;

    public Player(String name) {
        this.name = new Name(name);
        player = new Person();
    }

    public void initDeal(Deck deck) {
        player.initDeal(deck);
    }

    public void drawCard(Deck deck) {
        player.drawCard(deck);
    }

    public boolean isHitPossible() {
        return player.isHitPossible(GameConstant.BUST_SCORE);
    }

    public int calculateTotalScore() {
        return player.calculateTotalScore();
    }

    public boolean isBlackjack() {
        return player.isBlackjack();
    }

    public String getName() {
        return name.getName();
    }

    public ArrayList<Card> getHand() {
        return player.getHand();
    }
}