package domain.logics;

import domain.person.Dealer;
import domain.person.Money;
import domain.person.Player;
import domain.person.Players;
import java.util.Map;

public class BettingLogic {

    public static void battleBeforeDistribution(Dealer dealer, Player player) {
        if (dealer.isBlackJack() && !player.isBlackJack()) {
            dealerWin(dealer, player);
        }
        if (!dealer.isBlackJack() && player.isBlackJack()) {
            playerWin(dealer, player);
        }
    }

    public static void battle(Dealer dealer, Players players, Map<Player, Money> initPlayersBettingInfo) {
        if (dealer.isBust()) {
            resetBettingMoney(players, dealer, initPlayersBettingInfo);
            return;
        }
        caculatePlayerMoney(dealer, players, initPlayersBettingInfo);
    }

    private static void caculatePlayerMoney(Dealer dealer, Players players, Map<Player, Money> initPlayersBettingInfo) {
        for (Player player : players.getPlayers()) {
            handlePlayerBust(player, dealer);
            handlePlayerNotBust(players, player, dealer, initPlayersBettingInfo);
        }
    }

    private static void handlePlayerBust(Player player, Dealer dealer) {
        if (player.isBust()) {
            dealerWin(dealer, player);
        }
    }

    private static void handlePlayerNotBust(Players players, Player player, Dealer dealer,
                                            Map<Player, Money> initPlayersBettingInfo) {
        if (!player.isBust()) {
            compareDealerAndPlayer(dealer, player, players, initPlayersBettingInfo);
        }
    }

    private static void resetBettingMoney(Players players, Dealer dealer, Map<Player, Money> initPlayersBettingInfo) {
        players.getPlayers().forEach((player -> {
            dealer.loseMoney(initPlayersBettingInfo.get(player));
            player.resetMoney(initPlayersBettingInfo.get(player));
        }));
    }

    private static void compareDealerAndPlayer(Dealer dealer, Player player,
                                               Players players, Map<Player, Money> initPlayersBettingInfo) {
        if (dealer.isBlackJack() && player.isBlackJack()) {
            resetBettingMoney(players, dealer, initPlayersBettingInfo);
            return;
        }
        if (dealer.isBlackJack() || dealer.getSumOfCards() > player.getSumOfCards()) {
            dealerWin(dealer, player);
            return;
        }
        if (player.isBlackJack() || dealer.getSumOfCards() < player.getSumOfCards()) {
            playerWin(dealer, player);
        }
    }

    private static void dealerWin(Dealer dealer, Player player) {
        player.loseMoney();
        dealer.earnMoney(Money.create(player.getMoney()));
    }

    private static void playerWin(Dealer dealer, Player player) {
        player.earnMoney();
        dealer.loseMoney(Money.create(player.getMoney()));
    }
}