package blackjack.domain.validator;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNamesValidator {

    public static final String DUPLICATED_EXCEPTION_MESSAGE = "중복된 이름은 사용할 수 없습니다.";
    public static final String BLANK_EXCEPTION_MESSAGE = "이름은 최소 1글자입니다.";

    public static void validate(final List<String> playerNames) {
        if (isDuplicated(playerNames)) {
            throw new IllegalArgumentException(DUPLICATED_EXCEPTION_MESSAGE);
        }

        if (isBlank(playerNames)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    public static boolean isDuplicated(final List<String> playerNames) {
        return playerNames.stream().distinct().count() != playerNames.size();
    }

    public static boolean isBlank(final List<String> playerNames) {
        final List<String> blanks = playerNames.stream().filter(String::isBlank)
                .collect(Collectors.toUnmodifiableList());
        return !blanks.isEmpty();
    }
}