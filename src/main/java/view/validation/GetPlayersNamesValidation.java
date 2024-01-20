package src.main.java.view.validation;

import java.util.HashSet;
import java.util.Set;

public class GetPlayersNamesValidation {
    public static void validate(String[] playerNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name : playerNames) {
            validateName(name, nameSet);
        }
    }

    private static void validateName(String name, Set<String> nameSet) {
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름은 비어있을 수 없습니다.");
        }
        if (!nameSet.add(trimmedName)) {
            throw new IllegalArgumentException("플레이어 이름이 중복됩니다: " + trimmedName);
        }
    }
}
