package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    Deck deck;
    Player player;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        player = new Player("pobi");
    }

    @ParameterizedTest
    @DisplayName("점수에 따른 isBust() 테스트")
    @CsvSource(value = {"1:false", "7:true"}, delimiter = ':')
    void isBustTest(int input, boolean expected) {
        // given
        player.pickCard(deck, 11); // QUEEN CLOVER
        player.pickCard(deck, 8); // 9 CLOVER
        player.pickCard(deck, input); // 2 CLOVER, 8 CLOVER

        // when
        boolean result = player.isBust();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("점수에 따른 isHittable() 테스트")
    @CsvSource(value = {"0:false", "10:true"}, delimiter = ':')
    void isHittableTest(int input, boolean expected) {
        // given
        player.pickCard(deck, 11); // QUEEN CLOVER
        player.pickCard(deck, input); // ACE CLOVER, JACK CLOVER

        // when
        boolean result = player.isHittable();

        // then
        assertThat(result).isEqualTo(expected);
    }
}