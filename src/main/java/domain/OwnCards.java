package domain;

import java.util.ArrayList;
import java.util.List;

public class OwnCards {

    private final List<Card> ownCards;

    public OwnCards() {
        ownCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        ownCards.add(card);
    }
}
