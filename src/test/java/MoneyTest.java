import static org.assertj.core.api.Assertions.assertThat;

import domain.logics.EarnMoneyLogic;
import domain.person.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("Money가 immutable하게 잘 생성되는 지 테스트")
    @Test
    void createMoneyImmutableTest() {
        // given
        Money money = Money.create(3);

        // when
        Money money2 = money.add(Money.create(5));

        // then
        assertThat(money).isNotEqualTo(money2);
    }

    @DisplayName("Money에 더하고 빼는 것이 잘 되는 지 테스트")
    @Test
    void addAndSubtractMoneyTest() {
        // given
        Money money = Money.create(5);

        // when
        Money money2 = money.add(Money.create(5));
        Money money3 = money2.subtract(Money.create(3));

        // then
        assertThat(money3.getMoney()).isEqualTo(7);
    }

    @DisplayName("EarnMoneyLogic에 따라 multiplier 선택을 통해 비율이 잘 조정되는 지 테스트")
    @Test
    void selectMultiplierTest() {
        // given
        Money money1 = Money.create(10);
        Money money2 = Money.create(10);
        Money money3 = Money.create(10);

        // when
        Money winMoney = EarnMoneyLogic.WIN.calculateMoney(money1);
        Money loseMoney = EarnMoneyLogic.LOSE.calculateMoney(money2);
        Money BonuseMoney = EarnMoneyLogic.BONUS.calculateMoney(money3);

        // then
        assertThat(winMoney.getMoney()).isEqualTo(10);
        assertThat(loseMoney.getMoney()).isEqualTo(-10);
        assertThat(BonuseMoney.getMoney()).isEqualTo(15);
    }
}
