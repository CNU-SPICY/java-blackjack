package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Deck deck;
    Player player;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        player = new Player("pobi");
    }

    @Test
    @DisplayName("21점보다 클 때 isDead() 테스트")
    void isDeadTest() {
        // given
        player.pickCard(deck, 11); // QUEEN CLOVER
        player.pickCard(deck, 10); // JACK CLOVER
        player.pickCard(deck, 1); // 2 CLOVER

        // when
        boolean result = player.isBust();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("21점보다 작거나 같을 때 isDead() 테스트")
    void isDeadTest2() {
        // given
        player.pickCard(deck, 11); // QUEEN CLOVER
        player.pickCard(deck, 0); // ACE CLOVER

        // when
        boolean result = player.isBust();

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("21점보다 크거나 같을 때 canPickCard() 테스트")
    void canPickCardTest() {
        // given
        player.pickCard(deck, 11); // QUEEN CLOVER
        player.pickCard(deck, 0); // ACE CLOVER

        // when
        boolean result = player.isHittable();

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("21점보다 작을 때 canPickCard() 테스트")
    void canPickCardTest2() {
        // given
        player.pickCard(deck, 11); // QUEEN CLOVER
        player.pickCard(deck, 10); // JACK CLOVER

        // when
        boolean result = player.isHittable();

        // then
        assertThat(result).isEqualTo(true);
    }
}