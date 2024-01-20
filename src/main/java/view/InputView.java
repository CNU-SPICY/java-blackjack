package src.main.java.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getPlayersNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();
        String[] playerNames = inputNames.split(",");
        GetPlayersNamesValidation.validate(playerNames);
        return playerNames;
    }

    public static boolean askGetMore(String playerName) {
        System.out.println(playerName + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
        String reply = scanner.nextLine();
        AskGetMoreValidation.validate(reply);
        return reply.equals("y");
    }
}