package view;

import domain.validator.InputCardConditionValidator;
import domain.validator.InputPlayerNameValidator;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<String> inputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner sc = new Scanner(System.in);
        List<String> names = List.of(sc.nextLine().split(","));
        InputPlayerNameValidator.validate(names);
        return names;
    }

    public static boolean getCardCondition(String playerName) {
        System.out.println(playerName + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim().toLowerCase();
        InputCardConditionValidator.validate(input);
        return input.equals("y");
    }

    public static Integer askPlayerBetAmount(String playerName) {
        System.out.println(playerName + "의 배팅 금액은?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim().toLowerCase();
        return Integer.parseInt(input);
    }
}
