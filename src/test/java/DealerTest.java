package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.java.domain.Dealer;
import src.main.java.domain.Card;
import src.main.java.domain.Suit;

class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
    }

    @Test
    void testGetFaceUpCardWhenHandIsEmpty() {
        assertNull(dealer.getFaceUpCard(), "딜러의 손이 비었을 떈 null을 반환해야 함");
    }

    @Test
    void testGetFaceUpCardWhenHandIsNotEmpty() {
        // Given
        dealer.receiveCard(new Card(Suit.HEART, "10"));
        dealer.receiveCard(new Card(Suit.DIAMOND, "7"));

        // When
        String faceUpCard = dealer.getFaceUpCard();

        // Then
        assertEquals("10하트", faceUpCard, "딜러가 가장 첫 번째로 받은 카드를 반환해야 함");
    }

    @Test
    void testDealerShouldReceiveCard() {
        // Given
        dealer.receiveCard(new Card(Suit.CLUB, "6"));

        // When
        boolean shouldReceive = dealer.dealerShouldReceiveCard();

        // Then
        assertTrue(shouldReceive, "딜러의 점수 합이 16 이하 일 때 카드를 한 장 더 받아야함");
    }

    @Test
    void testDealerShouldNotReceiveCard() {
        // Given
        dealer.receiveCard(new Card(Suit.CLUB, "10"));
        dealer.receiveCard(new Card(Suit.DIAMOND, "7"));

        // When
        boolean shouldReceive = dealer.dealerShouldReceiveCard();

        // Then
        assertFalse(shouldReceive, "딜러의 점수 합이 17 이상이면 카드를 받지 말아야 함");
    }

    @Test
    void testDealerReceivedCard() {
        // Given
        assertFalse(dealer.isHasReceive(), "처음엔 딜러가 카드를 받지 않은 상태여야 함(hasReceive 값이 false)");

        // When
        dealer.dealerReceivedCard();

        // Then
        assertTrue(dealer.isHasReceive(), "딜러가 카드를 받으면 hasReceive 값이 true여야 함");
    }
}