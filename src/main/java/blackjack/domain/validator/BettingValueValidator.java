package blackjack.domain.validator;

public class BettingValueValidator {

    public static final String EXCEPTION_MESSAGE = "배팅 금액은 양의 정수입니다.";

    public static void validate(String betting) {
        if(Integer.parseInt(betting) <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}