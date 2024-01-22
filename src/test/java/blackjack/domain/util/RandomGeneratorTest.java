package blackjack.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Deck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤값 범위 확인")
    void generate() {
        // given
        Deck deck = new Deck();
        RandomGenerator randomGenerator = new RandomGenerator(deck);

        // when
        int random = randomGenerator.generate();

        // then
        assertThat(random).isBetween(0, deck.getSizeOfDeck()-1);
    }
}