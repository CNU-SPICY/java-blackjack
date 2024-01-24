package blackjack.view;

import blackjack.domain.*;
import blackjack.domain.person.Dealer;
import blackjack.domain.person.Player;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void initDeal(ArrayList<Player> players) {
        StringBuilder comment = new StringBuilder("딜러와 ");
        String playerNames = String.join(", ", players.stream()
                .map(Player::getName)
                .toArray(String[]::new));
        comment.append(playerNames);
        comment.append("에게 2장을 나누었습니다.");
        System.out.println(comment);
    }

    public void printAllHands(Dealer dealer, ArrayList<Player> players) {
        System.out.println(getDealerHand(dealer));
        System.out.println();
        for (Player player : players) {
            System.out.println(getPlayerHand(player));
        }
        System.out.println();
    }

    public StringBuilder getPlayerHand(Player player) {
        StringBuilder result = new StringBuilder(player.getName() + "카드: ");
        String cardInfo = player.getHand().stream()
                .map(card -> card.getDenomination() + card.getSuit())
                .collect(Collectors.joining(", "));
        result.append(cardInfo);
        return result;
    }

    public StringBuilder getDealerHand(Dealer dealer) {
        StringBuilder result = new StringBuilder("딜러 카드: ");
        String cardInfo = dealer.getHand().stream()
                .map(card -> card.getDenomination() + card.getSuit())
                .collect(Collectors.joining(", "));
        result.append(cardInfo);
        return result;
    }

    public void printPlayerHand(Player player) {
        System.out.println(getPlayerHand(player));
    }

    public void dealerHitComment() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public void printScoreResult(Dealer dealer, ArrayList<Player> players) {
        System.out.println(getDealerHand(dealer) + " - 결과: " + dealer.calculateTotalScore());
        for (Player player : players) {
            System.out.println(getPlayerHand(player) + " - 결과: " + player.calculateTotalScore());
        }
        System.out.println();
    }

    public void printGameResult(Result result) {
        System.out.println("## 최종 수익");
        printDealerResult(result);
        printPlayersResult(result);
    }

    private void printDealerResult(Result result) {
        System.out.println("딜러: " + result.getDealerAmount());
    }

    private void printPlayersResult(Result result) {
        Map<String, Integer> playersResult = result.getPlayerResults();
        for (Map.Entry<String, Integer> entry : playersResult.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void printNewLine() {
        System.out.println();
    }
}
