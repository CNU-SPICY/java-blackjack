package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerCardsTest {

    PlayerCards playerCards;

    @BeforeEach
    void setUp() {
        playerCards = new PlayerCards();
    }

    @Test
    @DisplayName("에이스를 포함하지 않는 점수 계산")
    void calcScoreTest() {
        // given
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.QUEEN));
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.JACK));

        // when
        int result = playerCards.calcScore();

        // then
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("1점 에이스를 포함할 때 점수 계산")
    void calcScoreTest2() {
        // given
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.QUEEN));
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.JACK));
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.ACE));

        // when
        int result = playerCards.calcScore();

        // then
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("11점 에이스를 포함할 때 점수 계산")
    void calcScoreTest3() {
        // given
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.JACK));
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.ACE));

        // when
        int result = playerCards.calcScore();

        // then
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("에이스 4장이 있을 때 점수 계산")
    void calcScoreTest4() {
        // given
        playerCards.addCard(new Card(CardType.CLOVER, CardNumber.ACE));
        playerCards.addCard(new Card(CardType.HEART, CardNumber.ACE));
        playerCards.addCard(new Card(CardType.DIAMOND, CardNumber.ACE));
        playerCards.addCard(new Card(CardType.SPADE, CardNumber.ACE));

        // when
        int result = playerCards.calcScore();

        // then
        assertThat(result).isEqualTo(14);
    }
}