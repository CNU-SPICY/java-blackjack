package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    Dealer dealer = new Dealer();
    Player player = new Player("pobi");

    @Test
    @DisplayName("승패결정이 잘 되는지를 테스트1")
    void decidePlayerResultTest1() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.ACE);
        Card card2 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.TEN);
        Card card3 = new Card(CardData.Suit.HEART, CardData.Denomination.SIX);
        Card card4 = new Card(CardData.Suit.SPADE, CardData.Denomination.FOUR);

        //when
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card3);
        dealer.addCardToHand(card4);
        player.addCardToHand(card1);
        player.addCardToHand(card2);

        //then
        assertThat(player.decidePlayerResult(dealer)).isEqualTo("블랙잭");
    }

    @Test
    @DisplayName("승패결정이 잘 되는지를 테스트2")
    void decidePlayerResultTest2() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.JACK);
        Card card2 = new Card(CardData.Suit.DIAMOND, CardData.Denomination.TEN);
        Card card3 = new Card(CardData.Suit.HEART, CardData.Denomination.SIX);
        Card card4 = new Card(CardData.Suit.SPADE, CardData.Denomination.FOUR);

        //when
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        dealer.addCardToHand(card3);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.addCardToHand(card4);

        //then
        assertThat(player.decidePlayerResult(dealer)).isEqualTo("패");
    }

    @Test
    @DisplayName("승패결정이 잘 되는지를 테스트3")
    void decidePlayerResultTest3() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.JACK);
        Card card2 = new Card(CardData.Suit.HEART, CardData.Denomination.SIX);
        Card card3 = new Card(CardData.Suit.SPADE, CardData.Denomination.FOUR);

        //when
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card3);
        player.addCardToHand(card1);
        player.addCardToHand(card2);

        //then
        assertThat(player.decidePlayerResult(dealer)).isEqualTo("승");
    }

    @Test
    @DisplayName("승패결정이 잘 되는지를 테스트4")
    void decidePlayerResultTest4() {
        //given
        Card card1 = new Card(CardData.Suit.CLUB, CardData.Denomination.JACK);
        Card card2 = new Card(CardData.Suit.HEART, CardData.Denomination.SIX);

        //when
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        player.addCardToHand(card1);
        player.addCardToHand(card2);

        //then
        assertThat(player.decidePlayerResult(dealer)).isEqualTo("무");
    }
}