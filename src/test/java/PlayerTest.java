package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.java.domain.Player;
import src.main.java.domain.Card;
import src.main.java.domain.Suit;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer");
    }

    @Test
    void testReceiveAndGetHand() {
        // Given
        Card card = new Card(Suit.CLUB, "5");

        // When
        player.receiveCard(card);

        // Then
        assertEquals(1, player.getHand().size());
        assertEquals(card, player.getHand().get(0));
    }

    @Test
    void testHandToString() {
        // Given
        player.receiveCard(new Card(Suit.CLUB, "5"));
        player.receiveCard(new Card(Suit.HEART, "A"));

        // When
        String handString = player.handToString();

        // Then
        assertEquals("5클로버, A하트", handString);
    }

    @Test
    void testCalculateScoreWithAceAsEleven() {
        // Given
        player.receiveCard(new Card(Suit.HEART, "A"));
        player.receiveCard(new Card(Suit.CLUB, "5"));

        //When
        int score = player.calculateScore();

        // Then
        assertEquals(16, score, "에이스가 11로 카운팅되어 총점이 16이 되어야함");
    }

    @Test
    void testCalculateScoreWithAceAsOne() {
        // Given
        player.receiveCard(new Card(Suit.HEART, "A"));
        player.receiveCard(new Card(Suit.CLUB, "10"));
        player.receiveCard(new Card(Suit.DIAMOND, "10"));

        // When
        int score = player.calculateScore();

        // Then
        assertEquals(21, score, "에이스가 1로 카운팅 되어 총점이 21이 되어야함");
    }

    @Test
    void testCalculateScoreWithTwoAces() {
        // Given
        player.receiveCard(new Card(Suit.DIAMOND, "A"));
        player.receiveCard(new Card(Suit.CLUB, "A"));
        player.receiveCard(new Card(Suit.SPADE, "8"));

        // When
        int score = player.calculateScore();

        // Then
        assertEquals(20, score, "A, A, 8 일 경우 20이 되어야 함.");
    }

    @Test
    void testCalculateScoreWithThreeAces() {
        // Given
        player.receiveCard(new Card(Suit.DIAMOND, "A"));
        player.receiveCard(new Card(Suit.CLUB, "A"));
        player.receiveCard(new Card(Suit.SPADE, "A"));
        player.receiveCard(new Card(Suit.SPADE, "K"));
        player.receiveCard(new Card(Suit.CLUB, "8"));

        // When
        int score = player.calculateScore();

        // Then
        assertEquals(21, score, "A, A, A, K, 8 일 경우 21이 되어야 함");
    }

    @Test
    void testCalculateScoreWithOnlyThreeAces() {
        // Given
        player.receiveCard(new Card(Suit.DIAMOND, "A"));
        player.receiveCard(new Card(Suit.CLUB, "A"));
        player.receiveCard(new Card(Suit.SPADE, "A"));

        // When
        int score = player.calculateScore();

        // Then
        assertEquals(13, score, "A, A, A 일 경우 13이 되어야 함");
    }

    @Test
    void testCalculateScoreWithFourAces() {
        // Given
        player.receiveCard(new Card(Suit.DIAMOND, "A"));
        player.receiveCard(new Card(Suit.CLUB, "A"));
        player.receiveCard(new Card(Suit.SPADE, "A"));
        player.receiveCard(new Card(Suit.HEART, "A"));
        player.receiveCard(new Card(Suit.HEART, "J"));
        player.receiveCard(new Card(Suit.SPADE, "7"));

        // When
        int score = player.calculateScore();

        // Then
        assertEquals(21, score, "A, A, A, A, J, 7 일 경우 21이 되어야 함");
    }

    @Test
    void testCalculateScoreWithOnlyFourAces() {
        // Given
        player.receiveCard(new Card(Suit.DIAMOND, "A"));
        player.receiveCard(new Card(Suit.CLUB, "A"));
        player.receiveCard(new Card(Suit.SPADE, "A"));
        player.receiveCard(new Card(Suit.HEART, "A"));

        // When
        int score = player.calculateScore();

        // Then
        assertEquals(14, score, "A, A, A, A 일 경우 14가 되어야 함");
    }

    @Test
    void testIncrementWinsAndLossesAndDraws() {
        // When
        player.incrementWins();
        player.incrementLosses();
        player.incrementDraws();

        // Then
        assertEquals(1, player.getWins());
        assertEquals(1, player.getLosses());
        assertEquals(1, player.getDraws());
    }
}
