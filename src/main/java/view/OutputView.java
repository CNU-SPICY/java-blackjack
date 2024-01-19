package src.main.java.view;

import java.util.Map;

public class OutputView {
    public static void displayInitialHands(Map<String, String> playerHands, String dealerHand) {
        System.out.println("\n딜러와 " + String.join(", ", playerHands.keySet()) + "에게 2장을 나누었습니다.");
        System.out.println("딜러 : " + dealerHand);
        for (Map.Entry<String, String> entry : playerHands.entrySet()) {
            System.out.println(entry.getKey() + "의 카드: " + entry.getValue());
        }
    }

    public static void displayPlayerHand(String playerName, String hand) {
        System.out.println(playerName + "카드: " + hand);
    }

    public static void displayDealerReceivedCard() {
        System.out.println("\n딜러는 16 이하라 한 장의 카드를 더 받았습니다.\n");
    }

    public static void displayDealerResult(String dealerHand, int score) {
        System.out.println("딜러 카드: " + dealerHand + " - 결과: " + score);
    }

    public static void displayPlayerResult(String playerName, String playerHand, int score) {
        System.out.println(playerName + "카드: " + playerHand + " - 결과: " + score);
    }

    public static void displayDealerWins(int wins, int losses, int draws) {
        System.out.println("\n##최종 승패");
        System.out.println("딜러: " + wins + "승 " + losses + "패 " + draws + "무");
    }

    public static void displayPlayerWins(String playerName, int wins, int losses, int draws) {
        System.out.println(playerName + ": " + wins + "승 " + losses + "패 " + draws + "무");
    }
}