package view;

import dto.CardDto;
import dto.DealerDto;
import dto.PlayerDto;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void showDividePlayerCards(DealerDto dealerDto, List<PlayerDto> playerDtos) {
        System.out.println("\n" + dealerDto.getDealerName() + "와 " + getPlayersName(playerDtos) + "에게 2장을 나누었습니다.");
        showDealerCard(dealerDto.getDealerName(), dealerDto.getDealerCards());
        showPlayersCards(playerDtos);
        System.out.println();
    }

    private static String getPlayersName(List<PlayerDto> playerDtos) {
        List<String> playerNames = new ArrayList<>();
        for (PlayerDto playerDto : playerDtos) {
            playerNames.add(playerDto.getPlayerName());
        }
        return String.join(",", playerNames);
    }

    private static String cardSpliter(List<CardDto> cards) {
        List<String> resultFormat = new ArrayList<>();
        for (CardDto card : cards) {
            resultFormat.add(card.getCardRank() + card.getCardSuit());
        }
        return String.join(", ", resultFormat);
    }

    private static void showDealerCard(String dealerName, List<CardDto> dealerOwnCards) {
        String hideDealerCard = cardSpliter(dealerOwnCards).split(",")[0].trim();
        System.out.println(dealerName + ": " + hideDealerCard);
    }

    public static void showPlayersCards(List<PlayerDto> playerDtos) {
        for (PlayerDto playerDto : playerDtos) {
            showPlayerCard(playerDto);
        }
    }

    public static void showPlayerCard(PlayerDto playerDto) {
        System.out.println(playerDto.getPlayerName() + ": " + cardSpliter(playerDto.getPlayerCards()));
    }

    public static void confirmDealerRecivedCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void showTotalScore(DealerDto dealerDto, List<PlayerDto> playerDtos) {
        System.out.println();
        System.out.println(dealerDto.getDealerName() + ": " + cardSpliter(dealerDto.getDealerCards()) + " - 결과: "
                + dealerDto.getSumOfCards());
        for (PlayerDto playerDto : playerDtos) {
            showPlayerCardWithResult(playerDto);
        }
    }

    private static void showPlayerCardWithResult(PlayerDto playerDto) {
        System.out.println(playerDto.getPlayerName() + ": " + cardSpliter(playerDto.getPlayerCards()) + " - 결과: "
                + playerDto.getSumOfCards());
    }


    public static void showTotalMoney(List<PlayerDto> playersDto, DealerDto dealerDto) {
        System.out.println("\n## 최종 수익");
        System.out.println(dealerDto.getDealerName() + ": " + dealerDto.getMoney());
        for (PlayerDto playerDto : playersDto) {
            showPlayerToTalMoney(playerDto);
        }
    }

    private static void showPlayerToTalMoney(PlayerDto playerDto) {
        System.out.println(playerDto.getPlayerName() + ": " + playerDto.getMoney());
    }
}
