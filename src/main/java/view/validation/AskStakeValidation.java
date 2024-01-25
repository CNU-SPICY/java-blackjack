package src.main.java.view.validation;

public class AskStakeValidation {

    public static void validate(int stake) {
        if (stake < 0) {
            throw new IllegalArgumentException("베팅 금액은 음수가 될 수 없습니다.");
        }
    }
}
