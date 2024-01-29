import static org.assertj.core.api.Assertions.assertThat;

import domain.cards.Deck;
import domain.cards.OwnCards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @DisplayName("초기 자신의 패에 두 개의 Card를 잘 뽑는 지 테스트")
    @Test
    void pickTwoCardTest() {
        // given
        OwnCards ownCards = OwnCards.create();
        Deck deck = new Deck();

        // when
        ownCards.getRandomTwoCards(deck.getRandomCard(), deck.getRandomCard());

        // then
        assertThat(ownCards.getOwnCards().size()).isEqualTo(2);
    }

    @DisplayName("자신의 패에 Card가 잘 추가되는 지 테스트")
    @Test
    void addCardTest() {
        // given
        OwnCards ownCards = OwnCards.create();
        Deck deck = new Deck();

        // when
        ownCards.addCard(deck.getRandomCard());

        // then
        assertThat(ownCards.getOwnCards().size()).isEqualTo(1);
    }
}
