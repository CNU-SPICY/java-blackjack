package blackjack.view;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public String[] getPlayerNames() {
        System.out.println("게임 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)");
        String names = sc.next();
        return names.split(",");
    }

    public boolean getHitDecision(String playerName) {
        System.out.println(playerName + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
        String hitDecision = sc.next();
        if(hitDecision.charAt(0) == 'y'){
            return true;
        }
        return false;
    }
}
