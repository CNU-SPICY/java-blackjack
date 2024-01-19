package src.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.domain.Card;
import src.main.java.domain.Suit;

class CardTest {

    private Card aceCard;
    private Card kingCard;
    private Card queenCard;
    private Card jackCard;
    private Card numberCard;

    @BeforeEach
    void setUp() {
        aceCard = new Card(Suit.SPADE, "A");
        kingCard = new Card(Suit.HEART, "K");
        queenCard = new Card(Suit.DIAMOND, "Q");
        jackCard = new Card(Suit.CLUB, "J");
        numberCard = new Card(Suit.HEART, "7");
    }

    @Test
    void testGetValueForAce() {
        // When: 에이스 카드의 값이 주어지면
        int value = aceCard.getValue();

        // Then: value가 1이 되어야 함.
        assertEquals(1, value, "Ace should have a value of 1");
    }

    @Test
    void testGetValueForFaceCards() {
        // When: face cards들이 값이 주어졌을 때
        int kingValue = kingCard.getValue();
        int queenValue = queenCard.getValue();
        int jackValue = jackCard.getValue();

        // Then: 모두 10이 반환되어야함
        assertEquals(10, kingValue, "King should have a value of 10");
        assertEquals(10, queenValue, "Queen should have a value of 10");
        assertEquals(10, jackValue, "Jack should have a value of 10");
    }

    @Test
    void testGetValueForNumberCards() {
        // When: 숫자 카드가 주어졌을 때
        int value = numberCard.getValue();

        // Then: value는 해당 숫자 카드의 숫자로 반환되어야 함
        assertEquals(7, value, "Card with rank 7 should have a value of 7");
    }

    @Test
    void testToString() {
        // When: suit가 하트이고, rank가 7인 카드를 문자열로 반환할 때
        String cardString = numberCard.toString();

        // Then: 숫자 + 한글 rank 이름으로 반환되어야 함
        assertEquals("7하트", cardString, "7 heart should be '7하트'");
    }
}
