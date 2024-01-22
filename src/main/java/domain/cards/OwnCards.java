package domain.cards;

import domain.logics.SumLogic;
import dto.CardInfo;
import java.util.ArrayList;
import java.util.List;

public class OwnCards {

    private final List<Card> ownCards;

    public OwnCards() {
        ownCards = new ArrayList<>();
    }

    public void getRandomTwoCards(Deck deck) {
        addCard(deck);
        addCard(deck);
    }

    public void addCard(Deck deck) {
        ownCards.add(deck.getRandomCard());
    }

    public List<Card> getOwnCards() {
        return ownCards;
    }

    public List<CardInfo> getRankAndSuit() {
        List<CardInfo> cardInfos = new ArrayList<>();
        for (Card card : ownCards) {
            cardInfos.add(new CardInfo(card.getCardRank(), card.getCardSuit()));
        }
        return cardInfos;
    }

    public int getSumOfCards() {
        SumLogic sumLogic = new SumLogic();
        return sumLogic.applyLogic(ownCards);
    }
}
