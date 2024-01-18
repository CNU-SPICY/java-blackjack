package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.GameResult;
import blackjack.domain.Player;
import blackjack.domain.Players;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void allReceivedCard(Dealer dealer, Players players) {
        List<String> playerNames = players.getPlayers().stream().map(Player::getName).collect(Collectors.toList());
        System.out.println();
        System.out.println(dealer.getName() + "와 " + String.join(", ", playerNames) + "에게 " + Dealer.INITIAL_CARD_AMOUNT + "장을 나누었습니다.");
    }

    public void dealerReceivedCard(Dealer dealer) {
        System.out.println();
        System.out.println(dealer.getName() + "는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printStatusOfAll(Dealer dealer, Players players) {
        printStatus(dealer);
        players.getPlayers().forEach(this::printStatus);
        System.out.println();
    }

    public void printStatus(Player player) {
        System.out.println(getStatus(player));
    }

    public void printFinalStatusOfAll(Dealer dealer, Players players) {
        System.out.println();
        printFinalStatus(dealer);
        players.getPlayers().forEach(this::printFinalStatus);
    }

    public void printFinalStatus(Player player) {
        System.out.println(getStatus(player) + " - 결과: " + player.calcScore());
    }

    private String getStatus(Player player) {
        List<String> status = player.getCards().stream().map(this::getCardInfo)
                .collect(Collectors.toUnmodifiableList());
        return player.getName() + "카드: " + String.join(", ", status);
    }

    private String getCardInfo(Card card) {
        return card.getCardNumberName() + card.getCardTypeName();
    }

    public void printResult(Dealer dealer, Players players) {
        System.out.println();
        System.out.println("## 최종 승패");
        int dealerWin = (int) dealer.getGameResults().stream().filter(gameResult -> gameResult == GameResult.WIN).count();
        int dealerLose = (int) dealer.getGameResults().stream().filter(gameResult -> gameResult == GameResult.LOSE).count();
        int dealerDraw = dealer.getGameResults().size() - dealerWin - dealerLose;
        System.out.println(dealer.getName() + ": " + dealerWin + "승 " + dealerLose + "패 " + dealerDraw + "무");
        players.getPlayers().forEach(player -> System.out.println(player.getName() + ": " + player.getGameResult()));
    }
}
