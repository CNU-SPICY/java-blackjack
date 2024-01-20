package src.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.domain.Card;
import src.main.java.domain.Dealer;
import src.main.java.domain.Player;
import src.main.java.domain.Players;

class PlayersTest {

    private Players players;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        // Given
        String[] playerNames = {"pobi", "jason"};
        players = new Players(playerNames);
        dealer = new Dealer();
    }

    @Test
    void testDrawCard() {
        // When
        Card drawnCard = players.drawCard();

        // Then
        assertNotNull(drawnCard);
    }

    @Test
    void testStartGame() {
        // When
        players.startGame(dealer);

        // Then
        for (Player player : players.getPlayers()) {
            assertEquals(2, player.getHand().size());
        }
        assertEquals(2, dealer.getHand().size());
    }

    @Test
    void testGetPlayersHands() {
        // Given
        players.startGame(dealer);

        // When
        Map<String, String> playerHands = players.getPlayersHands();

        // Then
        assertFalse(playerHands.isEmpty());
        assertEquals(2, playerHands.size());
    }

    @Test
    void testPlayPlayerTurn() {
        // Given
        players.startGame(dealer);
        Player player = players.getPlayers().get(0);

        // When
        players.playPlayerTurn(player);

        // Then
        assertEquals(3, player.getHand().size());
    }

    @Test
    void testPlayDealerTurn() {
        // Given
        players.startGame(dealer);

        // When
        players.playDealerTurn(dealer);

        // Then: The dealer should have at least 2 cards in their hand
        assertTrue(dealer.getHand().size() >= 2);
    }

    @Test
    void testDetermineWinners() {
        // Given
        players.startGame(dealer);
        Player player = players.getPlayers().get(0);

        // When
        players.determineWinners(dealer);

        // Then
        assertTrue(player.getWins() >= 0 && player.getLosses() >= 0 && player.getDraws() >= 0);
        assertTrue(dealer.getWins() >= 0 && dealer.getLosses() >= 0 && dealer.getDraws() >= 0);
    }
}
