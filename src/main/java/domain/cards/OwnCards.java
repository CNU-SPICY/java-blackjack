package domain.cards;

import domain.logics.ScoreLogic;
import dto.CardDto;
import java.util.ArrayList;
import java.util.List;

public class OwnCards {

    private final List<Card> ownCards;
    private final ScoreLogic scoreLogic;

    private OwnCards() {
        ownCards = new ArrayList<>();
        scoreLogic = new ScoreLogic();
    }

    public static OwnCards create() {
        return new OwnCards();
    }

    public void getRandomTwoCards(Card firstCard, Card secondCard) {
        addCard(firstCard);
        addCard(secondCard);
    }

    public void addCard(Card card) {
        ownCards.add(card);
    }

    public List<Card> getOwnCards() {
        return ownCards;
    }

    public List<CardDto> getRankAndSuit() {
        List<CardDto> cardDtos = new ArrayList<>();
        for (Card card : ownCards) {
            cardDtos.add(new CardDto(card.getCardRank(), card.getCardSuit()));
        }
        return cardDtos;
    }

    public int getSumOfCards() {
        return scoreLogic.applyLogic(ownCards);
    }

    public boolean isBust() {
        return scoreLogic.isBust(getSumOfCards());
    }

    public boolean isBlackJack() {
        return scoreLogic.isBlackJack(getSumOfCards());
    }
}
