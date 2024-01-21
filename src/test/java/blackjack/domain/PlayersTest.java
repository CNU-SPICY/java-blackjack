package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import blackjack.domain.validator.PlayerSizeValidator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("플레이어가 1명일 때 생성자 테스트")
    void constructorTest() {
        // given
        List<String> playerNames = List.of(new String[]{"pobi"});

        // when
        Throwable thrown = catchThrowable(() -> {
            new Players(playerNames);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PlayerSizeValidator.EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("플레이어가 2명일 때 생성자 테스트")
    void constructorTest2() {
        // given
        List<String> playerNames = List.of(new String[]{"pobi", "jason"});

        // when
        Throwable thrown = catchThrowable(() -> {
            new Players(playerNames);
        });

        // then
        assertThat(thrown).doesNotThrowAnyException();
    }
}