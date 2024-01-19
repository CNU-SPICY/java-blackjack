package domain.validator;

public class InputCardConditionValidator {

    private static final String NOT_PERMIITED_INPUT = "y나 n 중에서 하나를 입력해 주세요.";

    public static void validate(String yesOrNo) {
        if (yesOrNo.equals("y")) {
            return;
        }
        if (yesOrNo.equals("n")) {
            return;
        }
        throw new IllegalArgumentException(NOT_PERMIITED_INPUT);
    }
}
