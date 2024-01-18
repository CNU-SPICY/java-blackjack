package view;

import domain.Card;
import domain.Dealer;
import domain.Player;
import domain.Players;
import java.util.List;

public class OutputView {

    public static void showDividePlayerCards(Dealer dealer, Players players) {
        System.out.println(dealer.getName() + "와 " + getPlayersName(players) + "에게 2장을 나누었습니다.");
        showPlayersCards(dealer, players, true);
    }

    private static String getPlayersName(Players players) {
        StringBuilder playerNames = new StringBuilder();
        players.getPlayers().forEach(player -> playerNames.append(player.getName()).append(", "));
        playerNames.deleteCharAt(playerNames.length() - 2);
        return playerNames.toString();
    }

    public static void showPlayersCards(Dealer dealer, Players players, boolean hideOption) {
        showDealerCard(dealer, hideOption);

        for (Player player : players.getPlayers()) {
            showPlayerCard(player);
        }
    }

    private static void showDealerCard(Dealer dealer, boolean hideOption) {
        StringBuilder dealerCards = new StringBuilder();
        dealerCards.append(dealer.getName()).append(": ");
        List<Card> ownCards = dealer.getOwnCards();

        System.out.println(dealerOutputFormatGenerator(ownCards, dealerCards, hideOption));
    }

    private static String dealerOutputFormatGenerator(List<Card> cards, StringBuilder dealerCards, Boolean hideOption) {
        if (hideOption) {
            cards.stream().limit(cards.size() - 1)
                    .forEach(card -> dealerCards.append(card.getCardFullName()).append(", "));
            dealerCards.deleteCharAt(dealerCards.length() - 2);
            return dealerCards.toString();
        }
        cards.forEach(card -> dealerCards.append(card.getCardFullName()).append(", "));
        dealerCards.deleteCharAt(dealerCards.length() - 2);
        return dealerCards.toString();
    }

    public static void showPlayerCard(Player player) {
        StringBuilder playerCards = new StringBuilder();
        playerCards.append(player.getName()).append(": ");
        List<Card> ownCards = player.getOwnCards();

        System.out.println(playerOutputFormatGenerator(ownCards, playerCards));
    }

    private static String playerOutputFormatGenerator(List<Card> cards, StringBuilder playerCards) {
        cards.forEach(card -> playerCards.append(card.getCardFullName()).append(", "));
        playerCards.deleteCharAt(playerCards.length() - 2);
        return playerCards.toString();
    }
}
