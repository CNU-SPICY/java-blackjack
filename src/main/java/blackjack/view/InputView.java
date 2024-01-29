package blackjack.view;

import blackjack.domain.Player;
import blackjack.domain.validator.BettingValueValidator;
import blackjack.domain.validator.PlayerNamesValidator;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> getPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String inputNames = scanner.nextLine();
        List<String> playerNames = List.of(inputNames.split(","));
        PlayerNamesValidator.validate(playerNames);
        return playerNames;
    }

    public int getBettingValue(Player player) {
        System.out.println();
        System.out.println(player.getName() + "의 배팅 금액은?");
        String input = scanner.nextLine();
        BettingValueValidator.validate(input);
        return Integer.parseInt(input);
    }

    public boolean getResponseWantCard(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }

    public void close() {
        scanner.close();
    }
}