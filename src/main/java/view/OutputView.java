package view;

import dto.CardInfo;
import dto.DealerInfo;
import dto.PlayerInfo;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void showDividePlayerCards(DealerInfo dealerInfo, List<PlayerInfo> playerInfos) {
        System.out.println("\n" + dealerInfo.getDealerName() + "와 " + getPlayersName(playerInfos) + "에게 2장을 나누었습니다.");
        showDealerCard(dealerInfo.getDealerName(), dealerInfo.getDealerCards());
        showPlayersCards(playerInfos);
        System.out.println();
    }

    private static String getPlayersName(List<PlayerInfo> playerInfos) {
        List<String> playerNames = new ArrayList<>();
        for (PlayerInfo playerInfo : playerInfos) {
            playerNames.add(playerInfo.getPlayerName());
        }
        return String.join(",", playerNames);
    }

    private static String cardSpliter(List<CardInfo> cards) {
        List<String> resultFormat = new ArrayList<>();
        for (CardInfo card : cards) {
            resultFormat.add(card.getCardRank() + card.getCardSuit());
        }
        return String.join(", ", resultFormat);
    }

    private static void showDealerCard(String dealerName, List<CardInfo> dealerOwnCards) {
        String hideDealerCard = cardSpliter(dealerOwnCards).split(",")[0].trim();
        System.out.println(dealerName + ": " + hideDealerCard);
    }

    public static void showPlayersCards(List<PlayerInfo> playerInfos) {
        for (PlayerInfo playerInfo : playerInfos) {
            showPlayerCard(playerInfo);
        }
    }

    public static void showPlayerCard(PlayerInfo playerInfo) {
        System.out.println(playerInfo.getPlayerName() + ": " + cardSpliter(playerInfo.getPlayerCards()));
    }

    public static void confirmDealerRecivedCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void showTotalScore(DealerInfo dealerInfo, List<PlayerInfo> playerInfos) {
        System.out.println();
        System.out.println(dealerInfo.getDealerName() + ": " + cardSpliter(dealerInfo.getDealerCards()) + " - 결과: "
                + dealerInfo.getSumOfCards());

        for (PlayerInfo playerInfo : playerInfos) {
            showPlayerCardWithResult(playerInfo);
        }
    }

    private static void showPlayerCardWithResult(PlayerInfo playerInfo) {
        System.out.println(playerInfo.getPlayerName() + ": " + cardSpliter(playerInfo.getPlayerCards()) + " - 결과: "
                + playerInfo.getSumOfCards());
    }

    public static void showDealerWinAndLoseResult(int winCount, int loseCount, int drawCount) {
        System.out.println(
                "딜러: " + winCount + "승 " + loseCount + "패 " + drawCount + "무");
    }

    public static void showPlayerWinAndLoseResult(String playerName, int battleResult) {
        if (battleResult == 1) {
            System.out.println(playerName + ": " + "승");
            return;
        }
        if (battleResult == -1) {
            System.out.println(playerName + ": " + "패");
            return;
        }
        System.out.println(playerName + ": " + "무");
    }
}
