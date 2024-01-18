package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.carddata.CardNumber;
import blackjack.domain.carddata.CardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    @DisplayName("Deck의 크기가 52개가 맞는지 테스트")
    void deckSize() {
        // when, then
        assertThat(deck.getSizeOfDeck()).isEqualTo(52);
    }

    @Test
    @DisplayName("Deck이 정상적으로 생성됐는지 테스트")
    void initDeckTest() {
        // when
        Card card = deck.popCard(40); // 2 SPADE

        // then
        assertThat(card).extracting("cardType").isEqualTo(CardType.SPADE);
        assertThat(card).extracting("cardNumber").isEqualTo(CardNumber.TWO);
    }
}