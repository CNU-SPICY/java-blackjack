package blackjack.view;

import blackjack.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void initDeal(ArrayList<Player> players) {
        String comment = "\n딜러와 ";
        for(Player player : players) {
            comment += (player.getName() + ", ");
        }
        comment = comment.substring(0, comment.length() - 2) + "에게 2장을 나누었습니다.";
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
        String result = player.getName() + "카드: ";
        for(Card card : player.getHand()) {
            result += card.getInfo() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        System.out.print(result);
    }

    public void printDealerHand(Dealer dealerer) {
        String result = "딜러: ";
        for(Card card : dealerer.getHand()) {
            result += card.getInfo() + ", ";
        }
        result = result.substring(0, result.length() - 2);
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
