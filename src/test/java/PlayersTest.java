package src.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.domain.card.Card;
import src.main.java.domain.card.Suit;
import src.main.java.domain.player.Dealer;
import src.main.java.domain.player.Player;
import src.main.java.domain.players.Players;

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
    void testPlayerNormalWin() {
        // Given
        Player player = players.getPlayers().get(0);
        player.bet(100);
        giveCardsToPlayer(player, new Card(Suit.HEART, "10"), new Card(Suit.SPADE, "9"));
        giveCardsToDealer(dealer, new Card(Suit.CLUB, "8"), new Card(Suit.DIAMOND, "7"));

        // When
        players.determineWinners(dealer);

        // Then
        assertEquals(100, player.getProfit()); // Player wins bet, earns double
    }

    @Test
    void testPlayerLose() {
        // Given
        Player player = players.getPlayers().get(0);
        player.bet(100);
        giveCardsToPlayer(player, new Card(Suit.HEART, "8"), new Card(Suit.SPADE, "7"));
        giveCardsToDealer(dealer, new Card(Suit.CLUB, "10"), new Card(Suit.DIAMOND, "9"));

        // When
        players.determineWinners(dealer);

        // Then
        assertEquals(-100, player.getProfit());
    }

    @Test
    void testPlayerBlackjackWin() {
        // Given
        Player player = players.getPlayers().get(0);
        player.bet(100);
        giveCardsToPlayer(player, new Card(Suit.HEART, "A"), new Card(Suit.SPADE, "K"));
        giveCardsToDealer(dealer, new Card(Suit.CLUB, "9"), new Card(Suit.DIAMOND, "8"));

        // When
        players.determineWinners(dealer);

        // Then
        assertEquals(150, player.getProfit()); // Player wins 1.5 times bet
    }

    private void giveCardsToPlayer(Player player, Card... cards) {
        for (Card card : cards) {
            player.receiveCard(card);
        }
    }

    private void giveCardsToDealer(Dealer dealer, Card... cards) {
        for (Card card : cards) {
            dealer.receiveCard(card);
        }
    }
}
