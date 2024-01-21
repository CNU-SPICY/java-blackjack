package src.main.java.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void displaySharedTwoCards(List<String> playerNames) {
        System.out.println("\n딜러와 " + String.join(", ", playerNames) + "에게 2장을 나누었습니다.");
    }


    public static String formatCards(Map<String, List<String>> handDetails) {
        String cardsInHand = handDetails.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(rank -> rank + entry.getKey()))
                .collect(Collectors.joining(", "));
        return cardsInHand;
    }

    public static void displayDealerHand(Map<String, String> faceUpCard) {
        Map.Entry<String, String> entry = faceUpCard.entrySet().iterator().next();
        System.out.println("딜러 카드: " + entry.getValue() + entry.getKey());
    }

    public static void displayPlayerHand(String playerName, String cardsInHand) {
        System.out.println(playerName + "카드: " + cardsInHand);
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