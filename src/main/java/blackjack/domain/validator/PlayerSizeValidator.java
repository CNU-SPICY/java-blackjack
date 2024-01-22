package blackjack.domain.validator;

import java.util.List;

public class PlayerSizeValidator {

    public static final String EXCEPTION_MESSAGE = "참가 인원은 2~8명입니다.";

    public static void validate(List<String> players) {
        if (players.size() < 2 || players.size() > 8) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}