package domain.person;

public class Money {

    private final double money;

    private Money(double money) {
        this.money = money;
    }

    public static Money create(double money) {
        return new Money(money);
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
