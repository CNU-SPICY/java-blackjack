package domain.validator;

import java.util.List;

public class InputPlayerNameValidator {

    private static final String EMPTY_INPUT_ERROR = "하나의 이름이라도 입력해주세요";
    private static final String DUPLICATE_NAME_ERROR = "중복된 이름을 입력해서는 안됩니다.";

    public static void validate(List<String> names) {
        if (isBlank(names)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
        if (isDuplicate(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    private static boolean isDuplicate(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    private static boolean isBlank(List<String> names) {
        return names.isEmpty() || names.stream().anyMatch(String::isBlank);
    }
}
