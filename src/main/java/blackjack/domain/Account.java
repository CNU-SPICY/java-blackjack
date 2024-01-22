package blackjack.domain;

public class Account {

    private int betting = 0;
    private int money = 0;

    public void addBetting(int betting) {
        this.betting += betting;
    }

    public int getBetting() {
        return betting;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return money;
    }
}