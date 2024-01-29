import static org.assertj.core.api.Assertions.assertThat;

import domain.cards.Card;
import domain.cards.constant.CardEnums.CardRank;
import domain.cards.constant.CardEnums.CardSuit;
import domain.logics.BettingLogic;
import domain.person.Dealer;
import domain.person.Money;
import domain.person.Player;
import domain.person.Players;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BettingLogicTest {

    @DisplayName("before distribution에서 dealer가 블랙잭인 경우")
    @Test
    void beforeDistributionDealerWinTest() {
        // given
        Dealer dealer = Dealer.create();
        Player player = Player.create("Player");
        player.betting(Money.create(10000));

        // when
        dealer.setFirstCards(new Card(CardSuit.CLOBA, CardRank.A), new Card(CardSuit.SPADE, CardRank.J));
        player.setFirstCards(new Card(CardSuit.SPADE, CardRank.FIVE), new Card(CardSuit.DIAMOND, CardRank.FOUR));
        BettingLogic.battleBeforeDistribution(dealer, player);

        // then
        assertThat(dealer.getMoney()).isEqualTo(10000);
        assertThat(player.getMoney()).isEqualTo(-10000);
    }

    @DisplayName("before distribution에서 player가 블랙잭인 경우")
    @Test
    void afterDistributionDealerWinTest() {
        // given
        Dealer dealer = Dealer.create();
        Player player = Player.create("Player");
        player.betting(Money.create(10000));

        // when
        player.setFirstCards(new Card(CardSuit.CLOBA, CardRank.A), new Card(CardSuit.SPADE, CardRank.J));
        dealer.setFirstCards(new Card(CardSuit.SPADE, CardRank.FIVE), new Card(CardSuit.DIAMOND, CardRank.FOUR));
        BettingLogic.battleBeforeDistribution(dealer, player);

        // then
        assertThat(player.getMoney()).isEqualTo(15000);
        assertThat(dealer.getMoney()).isEqualTo(-15000);
    }

    @DisplayName("player가 이긴 경우")
    @Test
    void battlePlayerWinTest() {
        // given
        Map<Player, Money> initPlayersBettingInfo = new HashMap<>();
        Dealer dealer = Dealer.create();
        Players players = Players.create(List.of("Player"));
        initPlayersBettingInfo.put(players.getPlayers().get(0), Money.create(10000));

        // when
        for (Player player : players.getPlayers()) {
            player.setFirstCards(new Card(CardSuit.CLOBA, CardRank.NINE), new Card(CardSuit.SPADE, CardRank.J));
            player.pickCard(new Card(CardSuit.SPADE, CardRank.A));
            player.betting(Money.create(10000));
        }
        dealer.setFirstCards(new Card(CardSuit.SPADE, CardRank.FIVE), new Card(CardSuit.DIAMOND, CardRank.FOUR));
        dealer.pickCard(new Card(CardSuit.DIAMOND, CardRank.SIX));
        BettingLogic.battle(dealer, players, initPlayersBettingInfo);

        // then
        assertThat(players.getPlayers().get(0).getMoney()).isEqualTo(10000);
        assertThat(dealer.getMoney()).isEqualTo(-10000);
    }

    @DisplayName("dealer가 이긴 경우")
    @Test
    void battleDealerWinTest() {
        // given
        Map<Player, Money> initPlayersBettingInfo = new HashMap<>();
        Dealer dealer = Dealer.create();
        Players players = Players.create(List.of("Player"));
        initPlayersBettingInfo.put(players.getPlayers().get(0), Money.create(10000));

        // when
        for (Player player : players.getPlayers()) {
            player.setFirstCards(new Card(CardSuit.CLOBA, CardRank.TWO), new Card(CardSuit.SPADE, CardRank.THREE));
            player.pickCard(new Card(CardSuit.SPADE, CardRank.FOUR));
            player.betting(Money.create(10000));
        }
        dealer.setFirstCards(new Card(CardSuit.SPADE, CardRank.SEVEN), new Card(CardSuit.DIAMOND, CardRank.NINE));
        dealer.pickCard(new Card(CardSuit.SPADE, CardRank.A));
        BettingLogic.battle(dealer, players, initPlayersBettingInfo);

        // then
        assertThat(players.getPlayers().get(0).getMoney()).isEqualTo(-10000);
        assertThat(dealer.getMoney()).isEqualTo(10000);
    }
}
