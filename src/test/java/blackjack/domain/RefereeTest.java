package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    Deck deck;
    Dealer dealer;
    Player player;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player("pobi");
    }

    @Test
    @DisplayName("딜러 26점과 플레이어 2점의 결과 확인")
    void decideResultTest() {
        // given
        dealer.pickCard(deck, 11); // QUEEN CLOVER
        dealer.pickCard(deck, 5); // 6 CLOVER
        dealer.pickCard(deck, 9); // JACK CLOVER
        player.pickCard(deck, 1); // 2 CLOVER

        // when
        Referee referee = new Referee();
        referee.decideResult(dealer, player);

        // then
        assertThat(dealer.getLoseCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("딜러 2점과 플레이어 11점의 결과 확인")
    void decideResultTest2() {
        // given
        dealer.pickCard(deck, 1); // 2 CLOVER
        player.pickCard(deck, 0); // ACE CLOVER

        // when
        Referee referee = new Referee();
        referee.decideResult(dealer, player);

        // then
        assertThat(dealer.getLoseCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("딜러 26점과 플레이어 27점의 결과 확인")
    void decideResultTest3() {
        // given
        dealer.pickCard(deck, 12); // QUEEN CLOVER
        dealer.pickCard(deck, 5); // 6 CLOVER
        dealer.pickCard(deck, 9); // JACK CLOVER
        player.pickCard(deck, 8); // 10 CLOVER
        player.pickCard(deck, 7); // 9 CLOVER
        player.pickCard(deck, 6); // 8 CLOVER

        // when
        Referee referee = new Referee();
        referee.decideResult(dealer, player);

        // then
        assertThat(dealer.getWinCount()).isEqualTo(1);
    }
}