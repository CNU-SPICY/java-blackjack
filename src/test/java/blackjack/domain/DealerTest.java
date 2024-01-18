package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("딜러의 최종 승패 확인")
    void decideResultOfAllTest() {
        // given
        dealer.pickCard(deck, 11); // QUEEN CLOVER
        dealer.pickCard(deck, 1); // ACE CLOVER
        players.getPlayers().forEach(player->dealer.giveCardToPlayer(player));

        // when
        dealer.decideResultOfAll(players);
        int result = (int) dealer.getGameResults().stream().filter(gameResult -> gameResult == GameResult.WIN).count();

        // then
        assertThat(result).isEqualTo(2);
    }
}