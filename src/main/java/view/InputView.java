package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public static String[] inputPlayerNames() throws IOException {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        return buffer.readLine().split(",");
    }
}
