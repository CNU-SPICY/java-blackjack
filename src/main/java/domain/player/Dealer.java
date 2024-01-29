package src.main.java.domain.player;

import src.main.java.domain.card.Card;
import src.main.java.domain.card.Rank;
import src.main.java.domain.card.Suit;
import src.main.java.domain.player.management.CardManagement;

import java.util.HashMap;
import java.util.Map;

public class Dealer extends Player {

    private boolean hasReceive = false;

    public Dealer() {
        super("딜러");
    }

    public Map<String, String> getFaceUpCard() {
        CardManagement cardManagement;
        if (!getHand().isEmpty()) {
            Card faceUpCard = getHand().get(0);
            Map<String, String> faceUpCardInfo = new HashMap<>();
            Suit faceUpCardSuit = faceUpCard.getSuit();
            Rank faceUpCardRank = faceUpCard.getRank();
            faceUpCardInfo.put(faceUpCardSuit.getName(), faceUpCardRank.toString());
            return faceUpCardInfo;
        }
        return null;
    }

    public boolean dealerShouldReceiveCard() {
        return !hasReceive && calculateScore() <= 16;
    }

    public void dealerReceivedCard() {
        hasReceive = true;
    }

    public boolean isHasReceive() {
        return hasReceive;
    }
}