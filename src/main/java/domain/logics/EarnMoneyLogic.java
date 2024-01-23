package domain.logics;

import domain.person.Money;

public enum EarnMoneyLogic {

    WIN(1),
    LOSE(-1),
    BONUS(1.5);

    private final double multiplier;

    EarnMoneyLogic(final double multiplier) {
        this.multiplier = multiplier;
    }

    public Money calculateMoney(final Money money) {
        return money.Multifly(multiplier);
    }
}
