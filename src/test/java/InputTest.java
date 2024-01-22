import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.validator.InputCardConditionValidator;
import domain.validator.InputPlayerNameValidator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @DisplayName("빈 이름 입력은 막아지는 지 테스트")
    @Test
    void emptyInputTest() {
        // given
        List<String> names = List.of("");
        // when, then
        assertThatThrownBy(() -> InputPlayerNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("하나의 이름이라도 입력해주세요");
    }

    @DisplayName("중복된 이름 입력이 막아지는 지 테스트")
    @Test
    void duplicatedInputTest() {
        // given
        List<String> names = Arrays.asList("짱구", "짱구", "맹구");
        // when, then
        assertThatThrownBy(() -> InputPlayerNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 입력해서는 안됩니다.");
    }

    @DisplayName("정상적인 이름 입력은 되는 지 테스트")
    @Test
    void normalInputTest() {
        // given
        List<String> names = Arrays.asList("짱구", "철수", "맹구");
        // when, then
        assertDoesNotThrow(() -> InputPlayerNameValidator.validate(names));
    }

    @DisplayName("카드 더 받을 지 묻는 Input 값이 적절하지 않을 때 테스트")
    @Test
    void getMoreCardConditionTest() {
        // given
        String input = "k";

        // when, then
        assertThatThrownBy(() -> InputCardConditionValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("y나 n 중에서 하나를 입력해 주세요.");
    }

    @DisplayName("카드 더 받을 지 묻는 Input 값이 공백일 때, 테스트")
    @Test
    void getMoreCardEmptyConditionTest() {
        // given
        String input = " ";

        // when, then
        assertThatThrownBy(() -> InputCardConditionValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("y나 n 중에서 하나를 입력해 주세요.");
    }

    @DisplayName("카드 더 받을 지 묻는 Input 값이 y일 때 테스트")
    @Test
    void getMoreCardNormalYCondition() {
        // given
        String input = "y";

        // when, then
        assertDoesNotThrow(() -> InputCardConditionValidator.validate(input));
    }

    @DisplayName("카드 더 받을 지 묻는 Input 값이 n일 때 테스트")
    @Test
    void getMoreCardNormalNCondition() {
        // given
        String input = "n";

        // when, then
        assertDoesNotThrow(() -> InputCardConditionValidator.validate(input));
    }
}
