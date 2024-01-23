package blackjack.view;

import blackjack.domain.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void initDeal(ArrayList<Player> players) {
        StringBuilder comment = new StringBuilder("\n딜러와 ");
        String playerNames = String.join(", ", players.stream()
                .map(Player::getName)
                .toArray(String[]::new));
        comment.append(playerNames);
        comment.append("에게 2장을 나누었습니다.");
        System.out.println(comment);
    }

    public void printAllHands(Dealer dealer, ArrayList<Player> players) {
        printDealerHand(dealer);
        System.out.println();
        for (Player player : players) {
            printPlayerHand(player);
            System.out.println();
        }
        System.out.println();
    }

    public void printPlayerHand(Player player) {
        StringBuilder result = new StringBuilder(player.getName() + "카드: ");
        String cardInfo = player.getHand().stream()
                .map(card -> card.getDenomination() + card.getSuit())
                .collect(Collectors.joining(", "));
        result.append(cardInfo);
        System.out.print(result);
    }

    public void printDealerHand(Dealer dealer) {
        StringBuilder result = new StringBuilder("딜러 카드: ");
        String cardInfo = dealer.getHand().stream()
                .map(card -> card.getDenomination() + card.getSuit())
                .collect(Collectors.joining(", "));
        result.append(cardInfo);
        System.out.print(result);
    }

    public void dealerHitComment() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public void printScoreResult(Dealer dealer, ArrayList<Player> players) {
        printDealerHand(dealer);
        System.out.println(" - 결과: " + dealer.calculateTotalScore());
        for (Player player : players) {
            printPlayerHand(player);
            System.out.println(" - 결과: " + player.calculateTotalScore());
        }
        System.out.println();
    }

    public void printGameResult(Result result) {
        System.out.println("## 최종 승패");
        printDealerResult(result);
        printPlayersResult(result);
    }

    private void printDealerResult(Result result) {
        System.out.print("딜러: ");
        if(result.getDealerWinCount() > 0) {
            System.out.println(result.getDealerWinCount() + "승");
        }
        if(result.getDealerPushCount() > 0) {
            System.out.println(result.getDealerPushCount() + "무");
        }
        if(result.getDealerLoseCount() > 0) {
            System.out.println(result.getDealerLoseCount() + "패");
        }
    }

    private void printPlayersResult(Result result) {
        Map<String, String> playersResult = result.getPlayerResults();
        for (Map.Entry<String, String> entry : playersResult.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void printNewLine() {
        System.out.println();
    }
}
