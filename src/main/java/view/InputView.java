package view;

import domain.Player;
import java.util.Scanner;

public class InputView {

    public static String[] inputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine().split(",");
    }

    public static boolean getCardCondition(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim().toLowerCase();
        return input.equals("y");
    }
}
