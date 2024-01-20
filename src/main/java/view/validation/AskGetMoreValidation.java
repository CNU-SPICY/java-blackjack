package src.main.java.view.validation;

public class AskGetMoreValidation {
    public static void validate(String response) {
        if (!response.equals("y") && !response.equals("n")) {
            throw new IllegalArgumentException("유효하지 않은 응답입니다. 'y' 또는 'n'을 입력해야 합니다.");
        }
    }
}