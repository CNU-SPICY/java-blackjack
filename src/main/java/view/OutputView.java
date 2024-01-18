package view;

import domain.Card;
import domain.Dealer;
import domain.Player;
import domain.Players;
import java.util.List;

public class OutputView {

    public static void showDividePlayerCards(Dealer dealer, Players players) {
        System.out.println(dealer.getName() + "와 " + getPlayersName(players) + "에게 2장을 나누었습니다.");
        showDealerCard(dealer, true);
        showPlayersCards(players);
    }

    private static String getPlayersName(Players players) {
        StringBuilder playerNames = new StringBuilder();
        players.getPlayers().forEach(player -> playerNames.append(player.getName()).append(", "));
        playerNames.deleteCharAt(playerNames.length() - 2);
        return playerNames.toString();
    }

    public static void showPlayersCards(Players players) {
        for (Player player : players.getPlayers()) {
            showPlayerCard(player);
        }
    }

    public static void showPlayerCard(Player player) {
        System.out.println(getPlayerCard(player));
    }

    private static void showDealerCard(Dealer dealer, boolean hideOption) {
        System.out.println(getDealerCard(dealer, hideOption));
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
        showDealerCard(dealer, false);
    }
}
