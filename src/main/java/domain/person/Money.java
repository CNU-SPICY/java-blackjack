package domain.person;

public class Money {

    private final double money;

    private Money(double money) {
        this.money = money;
    }

    public static Money create(double money) {
        return new Money(money);
    }
}
