import static org.assertj.core.api.Assertions.assertThat;

import domain.cards.Card;
import domain.cards.Deck;
import domain.cards.OwnCards;
import domain.cards.constant.CardEnums.CardRank;
import domain.cards.constant.CardEnums.CardSuit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @DisplayName("Card 객체 생성은 잘 되는 지 테스트")
    @Test
    void createCardTest() {
        // given
        Card card = new Card(CardSuit.SPADE, CardRank.J);

        // when
        String cardInfo = card.getCardFullName();

        // then
        assertThat(cardInfo).isEqualTo("J스페이드");
    }

    @DisplayName("초기 자신의 패에 두 개의 Card를 잘 뽑는 지 테스트")
    @Test
    void pickTwoCardTest() {
        // given
        OwnCards ownCards = new OwnCards();
        Deck deck = new Deck();

        // when
        ownCards.getRandomTwoCards(deck);

        // then
        assertThat(ownCards.getOwnCards().size()).isEqualTo(2);
    }

    @DisplayName("자신의 패에 Card가 잘 추가되는 지 테스트")
    @Test
    void addCardTest() {
        // given
        OwnCards ownCards = new OwnCards();
        Deck deck = new Deck();

        // when
        ownCards.addCard(deck);

        // then
        assertThat(ownCards.getOwnCards().size()).isEqualTo(1);
    }
}
