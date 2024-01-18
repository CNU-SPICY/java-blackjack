package view;

import domain.Card;
import domain.Dealer;
import domain.Player;
import domain.Players;
import java.util.List;

public class OutputView {

    public static void showDividePlayerCards(Dealer dealer, Players players) {
        System.out.println("\n" + dealer.getName() + "와 " + getPlayersName(players) + "에게 2장을 나누었습니다.");
        showDealerCard(dealer);
        showPlayersCards(players);
        System.out.println();
    }

    private static String getPlayersName(Players players) {
        StringBuilder playerNames = new StringBuilder();
        players.getPlayers().forEach(player -> playerNames.append(player.getName()).append(", "));
        playerNames.deleteCharAt(playerNames.length() - 2);
        return playerNames.toString();
    }

    private static void showDealerCard(Dealer dealer) {
        System.out.println(getDealerCard(dealer, true));
    }

    private static StringBuilder getDealerCard(Dealer dealer, boolean hideOption) {
        StringBuilder dealerCards = new StringBuilder();
        dealerCards.append(dealer.getName()).append(": ");
        List<Card> ownCards = dealer.getOwnCards();
        return dealerOutputFormatGenerator(ownCards, dealerCards, hideOption);
    }

    private static StringBuilder dealerOutputFormatGenerator(List<Card> cards, StringBuilder dealerCards,
                                                             Boolean hideOption) {
        if (hideOption) {
            cards.stream().limit(cards.size() - 1)
                    .forEach(card -> dealerCards.append(card.getCardFullName()).append(", "));
            dealerCards.deleteCharAt(dealerCards.length() - 2);
            return dealerCards;
        }
        cards.forEach(card -> dealerCards.append(card.getCardFullName()).append(", "));
        dealerCards.deleteCharAt(dealerCards.length() - 2);
        return dealerCards;
    }

    public static void showPlayersCards(Players players) {
        for (Player player : players.getPlayers()) {
            showPlayerCard(player);
        }
    }

    public static void showPlayerCard(Player player) {
        System.out.println(getPlayerCard(player));
    }

    public static StringBuilder getPlayerCard(Player player) {
        StringBuilder playerCards = new StringBuilder();
        playerCards.append(player.getName()).append(": ");
        List<Card> ownCards = player.getOwnCards();
        return playerOutputFormatGenerator(ownCards, playerCards);
    }

    private static StringBuilder playerOutputFormatGenerator(List<Card> cards, StringBuilder playerCards) {
        cards.forEach(card -> playerCards.append(card.getCardFullName()).append(", "));
        playerCards.deleteCharAt(playerCards.length() - 2);
        return playerCards;
    }

    public static void confirmDealerRecivedCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void showTotalScore(Dealer dealer, Players players) {
        System.out.println();
        StringBuilder sumOfDealerCard = getDealerCard(dealer, false).append(" - 결과: ").append(dealer.getSumOfCards());
        System.out.println(sumOfDealerCard);

        for (Player player : players.getPlayers()) {
            showPlayerCardWithResult(player);
        }
    }

    private static void showPlayerCardWithResult(Player player) {
        System.out.println(getPlayerCard(player) + " - 결과: " + player.getSumOfCards());
    }

    public static void showWinAndLoseResult(Dealer dealer, Players players) {
        System.out.println();
        showDealerWinAndLoseResult(dealer);
        for (Player player : players.getPlayers()) {
            showPlayerWinAndLoseResult(player);
        }
    }

    private static void showDealerWinAndLoseResult(Dealer dealer) {
        System.out.println(
                "딜러: " + dealer.getWinCount() + "승 " + dealer.getLoseCount() + "패 " + dealer.getDrawCount() + "무");
    }

    private static void showPlayerWinAndLoseResult(Player player) {
        System.out.println(player.getName() + ": " + player.getBattleResult());
    }
}
