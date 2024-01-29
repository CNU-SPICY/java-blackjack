package blackjack.domain;

import blackjack.domain.person.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ResultTest {
    Result result = new Result();
    Name pobi = new Name("pobi");
    Name crong = new Name("crong");
    Name loopy = new Name("loopy");
    Name eddy = new Name("eddy");

    @Test
    @DisplayName("승부결과에 따른 수익변동이 잘 되는지를 테스트")
    void updateBetAmount() {
        //given
        result.addBetAmount(pobi, 5000);
        result.addBetAmount(crong, 5000);
        result.addBetAmount(loopy, 5000);
        result.addBetAmount(eddy, 5000);

        //when
        result.updateBetAmount(pobi, "승");
        result.updateBetAmount(crong, "무");
        result.updateBetAmount(loopy, "패");
        result.updateBetAmount(eddy, "블랙잭");

        //then
        assertThat(result.getDealerAmount()).isEqualTo(-7500);
        assertThat(result.getPlayerResults().get(pobi)).isEqualTo(5000);
        assertThat(result.getPlayerResults().get(crong)).isEqualTo(0);
        assertThat(result.getPlayerResults().get(loopy)).isEqualTo(-5000);
        assertThat(result.getPlayerResults().get(eddy)).isEqualTo(7500);
    }
}