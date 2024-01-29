package domain.person;

public class Money {

    private final double money;

    private Money(final double money) {
        this.money = money;
    }

    public static Money create(final String money) {
        int castedMoney = typeCast(money);
        return new Money(castedMoney);
    }

    public static Money create(final double money) {
        return new Money(money);
    }

    private static int typeCast(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    public static Money zero() {
        return new Money(0);
    }

    public Money add(final Money money) {
        return new Money(this.money + money.getMoney());
    }

    public Money subtract(final Money money) {
        return new Money(this.money - money.getMoney());
    }

    public Money Multifly(final double multiplier) {
        return new Money(this.money * multiplier);
    }

    public double getMoney() {
        return money;
    }
}
