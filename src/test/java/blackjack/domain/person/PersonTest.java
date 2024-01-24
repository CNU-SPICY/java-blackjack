package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PersonTest {
    Person person = new Person();

    @Test
    @DisplayName("카드가 잘 추가되는지를 테스트")
    void addCardToHandTest() {
        //given
        Card card = new Card(CardData.Suit.CLUB, CardData.Denomination.ACE);

        //when
        person.addCardToHand(card);

        //then
        assertThat(person.getHand().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("카드점수가 정상적으로 더해지는지를 테스트1")
    void calculateTotalScoreTest1() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.ACE);
        Card card2 = new Card(CardData.Suit.CLUB, CardData.Denomination.TEN);

        //when
        person.addCardToHand(card1);
        person.addCardToHand(card2);

        //then
        assertThat(person.calculateTotalScore()).isEqualTo(21);
    }

    @Test
    @DisplayName("카드점수가 정상적으로 더해지는지를 테스트2")
    void calculateTotalScoreTest2() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.ACE);
        Card card2 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.ACE);
        Card card3 = new Card(CardData.Suit.HEART, CardData.Denomination.ACE);
        Card card4 = new Card(CardData.Suit.SPADE, CardData.Denomination.ACE);

        //when
        person.addCardToHand(card1);
        person.addCardToHand(card2);
        person.addCardToHand(card3);
        person.addCardToHand(card4);

        //then
        assertThat(person.calculateTotalScore()).isEqualTo(14);
    }

    @Test
    @DisplayName("카드점수가 정상적으로 더해지는지를 테스트3")
    void calculateTotalScoreTest3() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.ACE);
        Card card2 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.TEN);
        Card card3 = new Card(CardData.Suit.HEART, CardData.Denomination.THREE);

        //when
        person.addCardToHand(card1);
        person.addCardToHand(card2);
        person.addCardToHand(card3);

        //then
        assertThat(person.calculateTotalScore()).isEqualTo(14);
    }

    @Test
    @DisplayName("카드점수가 정상적으로 더해지는지를 테스트4")
    void calculateTotalScoreTest4() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.TEN);
        Card card2 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.TEN);
        Card card3 = new Card(CardData.Suit.HEART, CardData.Denomination.THREE);

        //when
        person.addCardToHand(card1);
        person.addCardToHand(card2);
        person.addCardToHand(card3);

        //then
        assertThat(person.calculateTotalScore()).isEqualTo(23);
    }

    @Test
    @DisplayName("블랙잭 여부를 잘 잡아내는지를 테스트1")
    void isBlackjackTest1() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.ACE);
        Card card2 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.TEN);

        //when
        person.addCardToHand(card1);
        person.addCardToHand(card2);

        //then
        assertThat(person.isBlackjack()).isEqualTo(true);
    }

    @Test
    @DisplayName("블랙잭 여부를 잘 잡아내는지를 테스트2")
    void isBlackjackTest2() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.ACE);
        Card card2 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.FOUR);
        Card card3 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.SIX);

        //when
        person.addCardToHand(card1);
        person.addCardToHand(card2);
        person.addCardToHand(card3);

        //then
        assertThat(person.isBlackjack()).isEqualTo(false);
    }
}