package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Deck;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    Deck deck;
    Dealer dealer;
    Players players;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        dealer = new Dealer(deck);
        List<String> playerNames = List.of(new String[]{"pobi", "crong"});
        players = new Players(playerNames);
        players.getPlayers().forEach(player -> player.addBetting(10));
    }

    @Test
    @DisplayName("처음 2장씩 나눠준 후 Deck 크기 확인")
    void giveInitialCardTest() {
        // given
        int initSizeOfDeck = deck.getSizeOfDeck();
        int playersSize = players.getPlayers().size();
        dealer.giveInitialCard(players);

        // when, then
        assertThat(deck.getSizeOfDeck()).isEqualTo(initSizeOfDeck - (playersSize + 1) * Dealer.INITIAL_CARD_AMOUNT);
    }

    @Test
    @DisplayName("21점 딜러와 카드 한 장인 플레이어와의 결과 확인")
    void decideResultOfAllTest() {
        // given
        dealer.pickCard(deck, 11); // QUEEN CLOVER
        dealer.pickCard(deck, 1); // ACE CLOVER
        players.getPlayers().forEach(player -> dealer.giveCardToPlayer(player));

        // when
        dealer.decideResultAll(players);

        // then
        assertThat(dealer.getMoney()).isEqualTo(20);
    }
}